// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.roster;

import java.util.*;
import java.math.*;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;


public class RosterShipsItemStateDto {

    private String key;

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    private java.util.Map<String, Object> value;

    public java.util.Map<String, Object> getValue()
    {
        return this.value;
    }

    public void setValue(java.util.Map<String, Object> value)
    {
        this.value = value;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Long offChainVersion;

    public Long getOffChainVersion()
    {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion)
    {
        this.offChainVersion = offChainVersion;
    }

    private RosterId rosterId;

    public RosterId getRosterId()
    {
        return this.rosterId;
    }

    public void setRosterId(RosterId rosterId)
    {
        this.rosterId = rosterId;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public RosterShipsItemStateDto[] toRosterShipsItemStateDtoArray(Iterable<RosterShipsItemState> states) {
            return toRosterShipsItemStateDtoList(states).toArray(new RosterShipsItemStateDto[0]);
        }

        public List<RosterShipsItemStateDto> toRosterShipsItemStateDtoList(Iterable<RosterShipsItemState> states) {
            ArrayList<RosterShipsItemStateDto> stateDtos = new ArrayList();
            for (RosterShipsItemState s : states) {
                RosterShipsItemStateDto dto = toRosterShipsItemStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public RosterShipsItemStateDto toRosterShipsItemStateDto(RosterShipsItemState state)
        {
            if(state == null) {
                return null;
            }
            RosterShipsItemStateDto dto = new RosterShipsItemStateDto();
            if (returnedFieldsContains("Key")) {
                dto.setKey(state.getKey());
            }
            if (returnedFieldsContains("Value")) {
                dto.setValue(state.getValue());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("OffChainVersion")) {
                dto.setOffChainVersion(state.getOffChainVersion());
            }
            if (returnedFieldsContains("RosterId")) {
                dto.setRosterId(state.getRosterId());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

