// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.itemcreation;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;

public interface ItemCreationStateRepository {
    ItemCreationState get(SkillTypeItemIdPair id, boolean nullAllowed);

    void save(ItemCreationState state);

    void merge(ItemCreationState detached);
}
