package com.lulan.shincolle.entity;

/**
 * entity that tracks liquid depth (for floating on water).
 */
public interface IFloatingEntity
{

    double getEntityDepth();

    void setEntityDepth(double depth);

    /** depth above which the entity starts to float up */
    double getEntityFloatingDepth();

    void setEntityFloatingDepth(double depth);


}
