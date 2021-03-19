package com.example.oktademoapp;

import com.example.oktademoapp.model.*;
import com.example.oktademoapp.pipelines.PipelineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@SpringBootTest
class OktaDemoAppApplicationTests {

	@Autowired
	PipelineRepository repository;

	@Autowired
	MongoOperations operations;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		Pipeline pipeline = new Pipeline();
		pipeline.setName("testing-name");

		PlanningLocation planningLocation = new PlanningLocation();
		planningLocation.setName("Jira Main");
		planningLocation.setType("Jira");
		planningLocation.setUrl("https://jira.pdaugavietis.staff.adaptavist.com");
		operations.save(planningLocation);
		pipeline.setPlanningLocation(planningLocation);

		SCMLocation scmLocation = new SCMLocation();
		scmLocation.setUrl("https://bitbucket.pdaugavietis.staff.adaptavist.com");
		operations.save(scmLocation);
		pipeline.setScmLocation(scmLocation);

		BuilderLocation builderLocation = new BuilderLocation();
		builderLocation.setName("Jenkins Main");
		builderLocation.setType("Jenkins");
		builderLocation.setUrl("https://jenkins.pdaugavietis.staff.adaptavist.com");
		operations.save(builderLocation);
		pipeline.setBuilderLocation(builderLocation);

		ArtifactLocation artifactLocation = new ArtifactLocation();
		artifactLocation.setName("Jira Main");
		artifactLocation.setType("Jira");
		artifactLocation.setUrl("https://jira.pdaugavietis.staff.adaptavist.com");
		operations.save(artifactLocation);
		pipeline.setArtifactLocation(artifactLocation);

		repository.save(pipeline);

	}
}
