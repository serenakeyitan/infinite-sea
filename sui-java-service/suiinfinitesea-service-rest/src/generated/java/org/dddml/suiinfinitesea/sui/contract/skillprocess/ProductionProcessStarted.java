// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.skillprocess;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.dddml.suiinfinitesea.sui.contract.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductionProcessStarted {
    private String id;

    private SkillProcessIdForEvent skillProcessId;

    private BigInteger version;

    private Long itemId;

    private BigInteger energyCost;

    private BigInteger startedAt;

    private BigInteger creationTime;

    private ItemIdQuantityPairsForEvent productionMaterials;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SkillProcessIdForEvent getSkillProcessId() {
        return skillProcessId;
    }

    public void setSkillProcessId(SkillProcessIdForEvent skillProcessId) {
        this.skillProcessId = skillProcessId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigInteger getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(BigInteger energyCost) {
        this.energyCost = energyCost;
    }

    public BigInteger getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(BigInteger startedAt) {
        this.startedAt = startedAt;
    }

    public BigInteger getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(BigInteger creationTime) {
        this.creationTime = creationTime;
    }

    public ItemIdQuantityPairsForEvent getProductionMaterials() {
        return productionMaterials;
    }

    public void setProductionMaterials(ItemIdQuantityPairsForEvent productionMaterials) {
        this.productionMaterials = productionMaterials;
    }

    @Override
    public String toString() {
        return "ProductionProcessStarted{" +
                "id=" + '\'' + id + '\'' +
                ", skillProcessId=" + skillProcessId +
                ", version=" + version +
                ", itemId=" + itemId +
                ", energyCost=" + energyCost +
                ", startedAt=" + startedAt +
                ", creationTime=" + creationTime +
                ", productionMaterials=" + productionMaterials +
                '}';
    }

}
