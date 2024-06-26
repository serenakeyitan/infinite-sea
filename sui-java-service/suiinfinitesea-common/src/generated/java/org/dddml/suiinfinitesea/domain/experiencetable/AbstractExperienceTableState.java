// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.experiencetable;

import java.util.*;
import java.math.*;
import org.dddml.suiinfinitesea.domain.*;
import java.util.Date;
import java.math.BigInteger;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.domain.experiencetable.ExperienceTableEvent.*;

public abstract class AbstractExperienceTableState implements ExperienceTableState.SqlExperienceTableState {

    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Long offChainVersion;

    public Long getOffChainVersion() {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion) {
        this.offChainVersion = offChainVersion;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    private BigInteger version;

    public BigInteger getVersion() {
        return this.version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    private List<ExperienceLevel> levels;

    public List<ExperienceLevel> getLevels() {
        return this.levels;
    }

    public void setLevels(List<ExperienceLevel> levels) {
        this.levels = levels;
    }

    public boolean isStateUnsaved() {
        return this.getOffChainVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractExperienceTableState(List<Event> events) {
        initializeForReapplying();
        if (events != null && events.size() > 0) {
            this.setId(((ExperienceTableEvent.SqlExperienceTableEvent) events.get(0)).getExperienceTableEventId().getId());
            for (Event e : events) {
                mutate(e);
                this.setOffChainVersion((this.getOffChainVersion() == null ? ExperienceTableState.VERSION_NULL : this.getOffChainVersion()) + 1);
            }
        }
    }


    public AbstractExperienceTableState() {
        initializeProperties();
    }

    protected void initializeForReapplying() {
        this.forReapplying = true;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj instanceof ExperienceTableState) {
            return Objects.equals(this.getId(), ((ExperienceTableState)obj).getId());
        }
        return false;
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (false) { 
            ;
        } else if (e instanceof AbstractExperienceTableEvent.InitExperienceTableEvent) {
            when((AbstractExperienceTableEvent.InitExperienceTableEvent)e);
        } else if (e instanceof AbstractExperienceTableEvent.ExperienceLevelAdded) {
            when((AbstractExperienceTableEvent.ExperienceLevelAdded)e);
        } else if (e instanceof AbstractExperienceTableEvent.ExperienceLevelUpdated) {
            when((AbstractExperienceTableEvent.ExperienceLevelUpdated)e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void merge(ExperienceTableState s) {
        if (s == this) {
            return;
        }
        this.setLevels(s.getLevels());
        this.setActive(s.getActive());
        this.setVersion(s.getVersion());
    }

    public void when(AbstractExperienceTableEvent.InitExperienceTableEvent e) {
        throwOnWrongEvent(e);

        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String eventStatus = e.getEventStatus();
        String EventStatus = eventStatus;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        ExperienceTableState updatedExperienceTableState = (ExperienceTableState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.experiencetable.__Init__Logic",
                    "mutate",
                    new Class[]{ExperienceTableState.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, eventStatus, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.experiencetable;
//
//public class __Init__Logic {
//    public static ExperienceTableState mutate(ExperienceTableState experienceTableState, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String eventStatus, MutationContext<ExperienceTableState, ExperienceTableState.MutableExperienceTableState> mutationContext) {
//    }
//}

        if (this != updatedExperienceTableState) { merge(updatedExperienceTableState); } //else do nothing

    }

    public void when(AbstractExperienceTableEvent.ExperienceLevelAdded e) {
        throwOnWrongEvent(e);

        Integer level = e.getLevel();
        Integer Level = level;
        Long experience = e.getExperience();
        Long Experience = experience;
        Long difference = e.getDifference();
        Long Difference = difference;
        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String eventStatus = e.getEventStatus();
        String EventStatus = eventStatus;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        ExperienceTableState updatedExperienceTableState = (ExperienceTableState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.experiencetable.AddLevelLogic",
                    "mutate",
                    new Class[]{ExperienceTableState.class, Integer.class, Long.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, level, experience, difference, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, eventStatus, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.experiencetable;
//
//public class AddLevelLogic {
//    public static ExperienceTableState mutate(ExperienceTableState experienceTableState, Integer level, Long experience, Long difference, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String eventStatus, MutationContext<ExperienceTableState, ExperienceTableState.MutableExperienceTableState> mutationContext) {
//    }
//}

        if (this != updatedExperienceTableState) { merge(updatedExperienceTableState); } //else do nothing

    }

    public void when(AbstractExperienceTableEvent.ExperienceLevelUpdated e) {
        throwOnWrongEvent(e);

        Integer level = e.getLevel();
        Integer Level = level;
        Long experience = e.getExperience();
        Long Experience = experience;
        Long difference = e.getDifference();
        Long Difference = difference;
        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String eventStatus = e.getEventStatus();
        String EventStatus = eventStatus;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        ExperienceTableState updatedExperienceTableState = (ExperienceTableState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.experiencetable.UpdateLevelLogic",
                    "mutate",
                    new Class[]{ExperienceTableState.class, Integer.class, Long.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, level, experience, difference, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, eventStatus, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.experiencetable;
//
//public class UpdateLevelLogic {
//    public static ExperienceTableState mutate(ExperienceTableState experienceTableState, Integer level, Long experience, Long difference, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String eventStatus, MutationContext<ExperienceTableState, ExperienceTableState.MutableExperienceTableState> mutationContext) {
//    }
//}

        if (this != updatedExperienceTableState) { merge(updatedExperienceTableState); } //else do nothing

    }

    public void save() {
    }

    protected void throwOnWrongEvent(ExperienceTableEvent event) {
        String stateEntityId = this.getId(); // Aggregate Id
        String eventEntityId = ((ExperienceTableEvent.SqlExperienceTableEvent)event).getExperienceTableEventId().getId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }


        Long stateVersion = this.getOffChainVersion();

    }


    public static class SimpleExperienceTableState extends AbstractExperienceTableState {

        public SimpleExperienceTableState() {
        }

        public SimpleExperienceTableState(List<Event> events) {
            super(events);
        }

        public static SimpleExperienceTableState newForReapplying() {
            SimpleExperienceTableState s = new SimpleExperienceTableState();
            s.initializeForReapplying();
            return s;
        }

    }



}

