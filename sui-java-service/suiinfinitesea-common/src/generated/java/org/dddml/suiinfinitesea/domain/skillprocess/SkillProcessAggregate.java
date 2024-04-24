// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.skillprocess;

import java.util.List;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.Event;
import org.dddml.suiinfinitesea.domain.Command;

public interface SkillProcessAggregate {
    SkillProcessState getState();

    List<Event> getChanges();

    void create(String player, Long offChainVersion, String commandId, String requesterId, SkillProcessCommands.Create c);

    void completeProduction(String player, SkillTypeItemIdPair itemProduction, String experienceTable, String clock, Long offChainVersion, String commandId, String requesterId, SkillProcessCommands.CompleteProduction c);

    void completeCreation(String player, SkillTypeItemIdPair itemCreation, String experienceTable, String clock, Long offChainVersion, String commandId, String requesterId, SkillProcessCommands.CompleteCreation c);

    void throwOnInvalidStateTransition(Command c);
}

