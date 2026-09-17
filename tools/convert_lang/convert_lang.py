#!/usr/bin/env python3
"""Convert 1.12.2 .lang files to 1.21.1 lang JSON.

Key remapping, per entry, first match wins:
  1. verbatim key after normalizing 'shincolle:' -> 'shincolle.'
     (covers unchanged gui./chat./book./entity. keys)
  2. English value match within the same key domain
     (tile.* -> block.*, item.* -> item.*, ...; covers renamed
     item/block ids without colliding across domains)
  3. whitespace-normalized value match within the domain
  4. keep the old key (dead keys are ignored by the game)

Inputs (paths relative to repo root):
  --en-old   legacy en_US.lang    (tools/convert_lang/en_US.lang, taken from
             git history commit 865ba71~1 — kept here for re-runnability)
  --en-new   new en_us.json       (src/main/resources/assets/shincolle/lang/en_us.json)
  --src      old .lang file       (e.g. .../zh_CN.lang)
  --dest     output json          (e.g. .../zh_cn.json)

Usage:
  python3 tools/convert_lang/convert_lang.py --src zh_CN.lang --dest zh_cn.json
"""

import json
import sys
import pathlib
import argparse

# old key prefix -> new key prefix (value matching is domain-restricted)
DOMAIN = {"tile": "block"}


def load_lang(path: pathlib.Path) -> dict:
    d = {}
    for line in path.read_text(encoding="utf-8").splitlines():
        if not line or line.startswith("#") or "=" not in line:
            continue
        k, v = line.split("=", 1)
        d[k.strip()] = v
    return d


def domain_of(key: str) -> str:
    head = key.split(".", 1)[0]
    return DOMAIN.get(head, head)


def main() -> int:
    root = pathlib.Path(__file__).resolve().parents[2]
    lang = root / "src/main/resources/assets/shincolle/lang"
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--en-old", type=pathlib.Path,
                    default=pathlib.Path(__file__).parent / "en_US.lang")
    ap.add_argument("--en-new", type=pathlib.Path, default=lang / "en_us.json")
    ap.add_argument("--src", type=pathlib.Path, required=True)
    ap.add_argument("--dest", type=pathlib.Path, required=True)
    args = ap.parse_args()

    en_old = load_lang(args.en_old)
    en_new = json.loads(args.en_new.read_text(encoding="utf-8"))
    src = load_lang(args.src)

    # (domain, english value) -> new key; and normalized variant
    val2new = {}
    val2new_norm = {}
    for k, v in en_new.items():
        dom = domain_of(k)
        val2new.setdefault((dom, v), k)
        val2new_norm.setdefault((dom, " ".join(v.split())), k)

    out = {}
    stats = {"same": 0, "value": 0, "norm": 0, "old": 0}
    for old_key, text in src.items():
        en_val = en_old.get(old_key)
        dom = domain_of(old_key)

        same = old_key.replace("shincolle:", "shincolle.")
        if same in en_new:
            out[same] = text
            stats["same"] += 1
        elif en_val is not None and (dom, en_val) in val2new:
            out[val2new[(dom, en_val)]] = text
            stats["value"] += 1
        elif en_val is not None and (dom, " ".join(en_val.split())) in val2new_norm:
            out[val2new_norm[(dom, " ".join(en_val.split()))]] = text
            stats["norm"] += 1
        else:
            out[old_key] = text
            stats["old"] += 1

    args.dest.parent.mkdir(parents=True, exist_ok=True)
    args.dest.write_text(
        json.dumps(out, indent=1, ensure_ascii=False) + "\n", encoding="utf-8")
    print(f"{args.src.name} -> {args.dest.name}: {len(out)} entries "
          f"(same-key:{stats['same']} value:{stats['value']} "
          f"norm:{stats['norm']} kept-old:{stats['old']})")
    return 0


if __name__ == "__main__":
    sys.exit(main())
