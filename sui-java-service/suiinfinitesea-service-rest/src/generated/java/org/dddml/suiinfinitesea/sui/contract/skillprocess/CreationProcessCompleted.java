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
public class CreationProcessCompleted {
    private String id;

    private SkillProcessIdForEvent skillProcessId;

    private BigInteger version;

    private Long itemId;

    private BigInteger startedAt;

    private BigInteger creationTime;

    private BigInteger endedAt;

    private Boolean successful;

    private Long quantity;

    private Long experience;

    private Integer newLevel;

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

    public BigInteger getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(BigInteger endedAt) {
        this.endedAt = endedAt;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public Integer getNewLevel() {
        return newLevel;
    }

    public void setNewLevel(Integer newLevel) {
        this.newLevel = newLevel;
    }

    @Override
    public String toString() {
        return "CreationProcessCompleted{" +
                "id=" + '\'' + id + '\'' +
                ", skillProcessId=" + skillProcessId +
                ", version=" + version +
                ", itemId=" + itemId +
                ", startedAt=" + startedAt +
                ", creationTime=" + creationTime +
                ", endedAt=" + endedAt +
                ", successful=" + successful +
                ", quantity=" + quantity +
                ", experience=" + experience +
                ", newLevel=" + newLevel +
                '}';
    }

}
