package com.lulan.shincolle.entity;

import com.lulan.shincolle.ai.path.IShipPathNavigate;

/**
 * entity with a ship path navigator (legacy IShipNavigator).
 */
public interface IShipNavigator
{

    IShipPathNavigate getShipNavigate();


}
