// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.config;

import org.dddml.suiinfinitesea.domain.skillprocess.*;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.domain.skillprocess.hibernate.*;
import org.dddml.suiinfinitesea.domain.item.*;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.domain.item.hibernate.*;
import org.dddml.suiinfinitesea.domain.itemcreation.*;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.domain.itemcreation.hibernate.*;
import org.dddml.suiinfinitesea.domain.itemproduction.*;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.domain.itemproduction.hibernate.*;
import org.dddml.suiinfinitesea.domain.player.*;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.domain.player.hibernate.*;
import org.dddml.suiinfinitesea.domain.experiencetable.*;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.domain.experiencetable.hibernate.*;
import org.dddml.suiinfinitesea.specialization.AggregateEventListener;
import org.dddml.suiinfinitesea.specialization.EventStore;
import org.dddml.suiinfinitesea.specialization.IdGenerator;
import org.dddml.suiinfinitesea.specialization.ReadOnlyProxyGenerator;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AggregatesHibernateConfig {


    @Bean
    public SkillProcessStateRepository skillProcessStateRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateSkillProcessStateRepository repository = new HibernateSkillProcessStateRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public SkillProcessStateQueryRepository skillProcessStateQueryRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateSkillProcessStateQueryRepository repository = new HibernateSkillProcessStateQueryRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public HibernateSkillProcessEventStore skillProcessEventStore(SessionFactory hibernateSessionFactory) {
        HibernateSkillProcessEventStore eventStore = new HibernateSkillProcessEventStore();
        eventStore.setSessionFactory(hibernateSessionFactory);
        return eventStore;
    }

    @Bean
    public AbstractSkillProcessApplicationService.SimpleSkillProcessApplicationService skillProcessApplicationService(
            @Qualifier("skillProcessEventStore") EventStore skillProcessEventStore,
            SkillProcessStateRepository skillProcessStateRepository,
            SkillProcessStateQueryRepository skillProcessStateQueryRepository
    ) {
        AbstractSkillProcessApplicationService.SimpleSkillProcessApplicationService applicationService = new AbstractSkillProcessApplicationService.SimpleSkillProcessApplicationService(
                skillProcessEventStore,
                skillProcessStateRepository,
                skillProcessStateQueryRepository
        );
        return applicationService;
    }



    @Bean
    public ItemStateRepository itemStateRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateItemStateRepository repository = new HibernateItemStateRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public ItemStateQueryRepository itemStateQueryRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateItemStateQueryRepository repository = new HibernateItemStateQueryRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public HibernateItemEventStore itemEventStore(SessionFactory hibernateSessionFactory) {
        HibernateItemEventStore eventStore = new HibernateItemEventStore();
        eventStore.setSessionFactory(hibernateSessionFactory);
        return eventStore;
    }

    @Bean
    public AbstractItemApplicationService.SimpleItemApplicationService itemApplicationService(
            @Qualifier("itemEventStore") EventStore itemEventStore,
            ItemStateRepository itemStateRepository,
            ItemStateQueryRepository itemStateQueryRepository
    ) {
        AbstractItemApplicationService.SimpleItemApplicationService applicationService = new AbstractItemApplicationService.SimpleItemApplicationService(
                itemEventStore,
                itemStateRepository,
                itemStateQueryRepository
        );
        return applicationService;
    }



    @Bean
    public ItemCreationStateRepository itemCreationStateRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateItemCreationStateRepository repository = new HibernateItemCreationStateRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public ItemCreationStateQueryRepository itemCreationStateQueryRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateItemCreationStateQueryRepository repository = new HibernateItemCreationStateQueryRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public HibernateItemCreationEventStore itemCreationEventStore(SessionFactory hibernateSessionFactory) {
        HibernateItemCreationEventStore eventStore = new HibernateItemCreationEventStore();
        eventStore.setSessionFactory(hibernateSessionFactory);
        return eventStore;
    }

    @Bean
    public AbstractItemCreationApplicationService.SimpleItemCreationApplicationService itemCreationApplicationService(
            @Qualifier("itemCreationEventStore") EventStore itemCreationEventStore,
            ItemCreationStateRepository itemCreationStateRepository,
            ItemCreationStateQueryRepository itemCreationStateQueryRepository
    ) {
        AbstractItemCreationApplicationService.SimpleItemCreationApplicationService applicationService = new AbstractItemCreationApplicationService.SimpleItemCreationApplicationService(
                itemCreationEventStore,
                itemCreationStateRepository,
                itemCreationStateQueryRepository
        );
        return applicationService;
    }



    @Bean
    public ItemProductionStateRepository itemProductionStateRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateItemProductionStateRepository repository = new HibernateItemProductionStateRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public ItemProductionStateQueryRepository itemProductionStateQueryRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateItemProductionStateQueryRepository repository = new HibernateItemProductionStateQueryRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public HibernateItemProductionEventStore itemProductionEventStore(SessionFactory hibernateSessionFactory) {
        HibernateItemProductionEventStore eventStore = new HibernateItemProductionEventStore();
        eventStore.setSessionFactory(hibernateSessionFactory);
        return eventStore;
    }

    @Bean
    public AbstractItemProductionApplicationService.SimpleItemProductionApplicationService itemProductionApplicationService(
            @Qualifier("itemProductionEventStore") EventStore itemProductionEventStore,
            ItemProductionStateRepository itemProductionStateRepository,
            ItemProductionStateQueryRepository itemProductionStateQueryRepository
    ) {
        AbstractItemProductionApplicationService.SimpleItemProductionApplicationService applicationService = new AbstractItemProductionApplicationService.SimpleItemProductionApplicationService(
                itemProductionEventStore,
                itemProductionStateRepository,
                itemProductionStateQueryRepository
        );
        return applicationService;
    }



    @Bean
    public PlayerItemEventDao playerItemEventDao(SessionFactory hibernateSessionFactory) {
        HibernatePlayerItemEventDao dao = new HibernatePlayerItemEventDao();
        dao.setSessionFactory(hibernateSessionFactory);
        return dao;
    }

    @Bean
    public PlayerStateRepository playerStateRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernatePlayerStateRepository repository = new HibernatePlayerStateRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public PlayerStateQueryRepository playerStateQueryRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernatePlayerStateQueryRepository repository = new HibernatePlayerStateQueryRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public HibernatePlayerEventStore playerEventStore(SessionFactory hibernateSessionFactory) {
        HibernatePlayerEventStore eventStore = new HibernatePlayerEventStore();
        eventStore.setSessionFactory(hibernateSessionFactory);
        return eventStore;
    }

    @Bean
    public AbstractPlayerApplicationService.SimplePlayerApplicationService playerApplicationService(
            @Qualifier("playerEventStore") EventStore playerEventStore,
            PlayerStateRepository playerStateRepository,
            PlayerStateQueryRepository playerStateQueryRepository
    ) {
        AbstractPlayerApplicationService.SimplePlayerApplicationService applicationService = new AbstractPlayerApplicationService.SimplePlayerApplicationService(
                playerEventStore,
                playerStateRepository,
                playerStateQueryRepository
        );
        return applicationService;
    }



    @Bean
    public ExperienceTableStateRepository experienceTableStateRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateExperienceTableStateRepository repository = new HibernateExperienceTableStateRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public ExperienceTableStateQueryRepository experienceTableStateQueryRepository(
            SessionFactory hibernateSessionFactory,
            ReadOnlyProxyGenerator stateReadOnlyProxyGenerator
    ) {
        HibernateExperienceTableStateQueryRepository repository = new HibernateExperienceTableStateQueryRepository();
        repository.setSessionFactory(hibernateSessionFactory);
        repository.setReadOnlyProxyGenerator(stateReadOnlyProxyGenerator);
        return repository;
    }

    @Bean
    public HibernateExperienceTableEventStore experienceTableEventStore(SessionFactory hibernateSessionFactory) {
        HibernateExperienceTableEventStore eventStore = new HibernateExperienceTableEventStore();
        eventStore.setSessionFactory(hibernateSessionFactory);
        return eventStore;
    }

    @Bean
    public AbstractExperienceTableApplicationService.SimpleExperienceTableApplicationService experienceTableApplicationService(
            @Qualifier("experienceTableEventStore") EventStore experienceTableEventStore,
            ExperienceTableStateRepository experienceTableStateRepository,
            ExperienceTableStateQueryRepository experienceTableStateQueryRepository
    ) {
        AbstractExperienceTableApplicationService.SimpleExperienceTableApplicationService applicationService = new AbstractExperienceTableApplicationService.SimpleExperienceTableApplicationService(
                experienceTableEventStore,
                experienceTableStateRepository,
                experienceTableStateQueryRepository
        );
        return applicationService;
    }


}
