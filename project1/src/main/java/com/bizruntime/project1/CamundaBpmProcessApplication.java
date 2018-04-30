package com.bizruntime.project1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;


@ProcessApplication
public class CamundaBpmProcessApplication extends ServletProcessApplication {

  private static final String PROCESS_DEFINITION_KEY = "project1";

  
  @PostDeploy
  public void onDeploymentFinished(ProcessEngine processEngine) {

/*RepositoryService repositoryService = processEngine.getRepositoryService();
	  List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
			    .processDefinitionKey("invoice")
			    .orderByProcessDefinitionVersion()
			    .asc()
			    .list();
*/
	  RuntimeService runtimeService = processEngine.getRuntimeService();
	  Map<String, Object> variables = new HashMap<String,Object>();
	  variables.put("creditor", "Nice Pizza Inc.");
	  ProcessInstance instance = runtimeService.startProcessInstanceByKey("invoice", variables);
   
  }

}
