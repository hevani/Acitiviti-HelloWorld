
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;


public class Main {
	
	public static void main(String[] args) {
		
		// Bootstrap
		/*ProcessEngine processEngine = new DbProcessEngineBuilder()
			.configureFromPropertiesResource("activiti.properties")
			.buildProcessEngine();
		 */
		ProcessEngine processEngine = ProcessEngineConfiguration
			        .createProcessEngineConfigurationFromResource("activiti.xml")
			        .buildProcessEngine();
		
		 RepositoryService repositoryService = processEngine.getRepositoryService(); 
		// Deployment
		 repositoryService.createDeployment()
			.addClasspathResource("hello-world.bpmn20.xml")
			.deploy();
		
		 
		 RuntimeService runtimeService=processEngine.getRuntimeService();
		 runtimeService.startProcessInstanceByKey("helloWorld");	 
	}
}
