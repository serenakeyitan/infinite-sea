// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.service;

import com.github.wubuku.sui.bean.*;
import com.github.wubuku.sui.utils.*;
import org.dddml.suiinfinitesea.domain.itemproduction.*;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.sui.contract.DomainBeanUtils;
import org.dddml.suiinfinitesea.sui.contract.ItemProduction;

import java.util.*;
import java.math.*;
import java.util.function.*;

public class SuiItemProductionStateRetriever {

    private SuiJsonRpcClient suiJsonRpcClient;

    private Function<SkillTypeItemIdPair, ItemProductionState.MutableItemProductionState> itemProductionStateFactory;

    public SuiItemProductionStateRetriever(SuiJsonRpcClient suiJsonRpcClient,
                                  Function<SkillTypeItemIdPair, ItemProductionState.MutableItemProductionState> itemProductionStateFactory
    ) {
        this.suiJsonRpcClient = suiJsonRpcClient;
        this.itemProductionStateFactory = itemProductionStateFactory;
    }

    public ItemProductionState retrieveItemProductionState(String objectId) {
        SuiMoveObjectResponse<ItemProduction> getObjectDataResponse = suiJsonRpcClient.getMoveObject(
                objectId, new SuiObjectDataOptions(true, true, true, true, true, true, true), ItemProduction.class
        );
        if (getObjectDataResponse.getData() == null) {
            return null;
        }
        ItemProduction itemProduction = getObjectDataResponse.getData().getContent().getFields();
        return toItemProductionState(itemProduction);
    }

    private ItemProductionState toItemProductionState(ItemProduction itemProduction) {
        ItemProductionState.MutableItemProductionState itemProductionState = itemProductionStateFactory.apply(DomainBeanUtils.toSkillTypeItemIdPair(itemProduction.getItemProductionId()));
        itemProductionState.setId_(itemProduction.getId().getId());
        itemProductionState.setVersion(itemProduction.getVersion());
        itemProductionState.setProductionMaterials(DomainBeanUtils.toItemIdQuantityPairs(itemProduction.getProductionMaterials()));
        itemProductionState.setRequirementsLevel(itemProduction.getRequirementsLevel());
        itemProductionState.setBaseQuantity(itemProduction.getBaseQuantity());
        itemProductionState.setBaseExperience(itemProduction.getBaseExperience());
        itemProductionState.setBaseCreationTime(itemProduction.getBaseCreationTime());
        itemProductionState.setEnergyCost(itemProduction.getEnergyCost());
        itemProductionState.setSuccessRate(itemProduction.getSuccessRate());
        return itemProductionState;
    }

    
}

