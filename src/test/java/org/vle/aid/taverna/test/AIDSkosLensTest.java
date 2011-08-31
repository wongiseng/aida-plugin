package org.vle.aid.taverna.test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Before;
import org.junit.Test;
import org.vle.aid.taverna.remote.AIDRemoteConfig;
import org.vle.aid.taverna.remote.AIDRemoteQuery;

public class AIDSkosLensTest {
	AIDRemoteQuery query;
	@Before
	public void setup(){
		query = new AIDRemoteQuery("http://dev.adaptivedisclosure.org","http://ws.adaptivedisclosure.org/openrdf-sesame/","tno","","");
	}

	@Test
	public void testRepositoryDetect() throws Exception{
		////System.out.println(query.getAvailablelLenses());
    	Call call = createAxisCall("http://dev.adaptivedisclosure.org/axis/services/RepositoryDetectWS", "detectRepository");
    	String[] result = (String []) call.invoke(new Object[] { "http://dev.adaptivedisclosure.org/openrdf-sesame","tno", "",""});
		//System.out.println(result[0]);
		//System.out.println(result[1]);
		
	}
//	@Test
//	public void testGetRepositories() throws Exception{
//		////System.out.println(query.getAvailablelLenses());
//    	Call call = createAxisCall("http://dev.adaptivedisclosure.org/axis/services/RepositoryWS", "getRepositories");
//    	
//    	String[] repositories = (String []) call.invoke(new Object[] { 
//    			"http://tarski.duhs.org:8080/openrdf-sesame",
//    			"","", // user name, password, scheme label
//    			});
//    	//System.out.println(repositories.length);
//    	for(String repository : repositories) //System.out.println("Check Repositories :"+repository);
//		
//	}
//	@Test
//	public void testGetConceptSchemesNonSkos() throws Exception{
//		////System.out.println(query.getAvailablelLenses());
//    	Call call = createAxisCall("http://dev.adaptivedisclosure.org/axis/services/SkosLensWS", "getConceptSchemes");
//	
//    	String[][] result = (String [][]) call.invoke(new Object[] { 
//    			"http://tarski.duhs.org:8080/openrdf-sesame","SNOMED", 
//    			"","",  // user name, password, scheme label
//    			"rdfs:Class", "rdfs:subClassOf", // Lenses
//    			"Not Skos", "Not a Virtuoso"
//    			});
//    	//System.out.println(result.length);
//    	for(String [] rows : result) //System.out.println("Check :"+Arrays.toString(rows));
//		
//	}
//	@Test
//	public void testGetConceptSchemesSkos2004() throws Exception{
//		////System.out.println(query.getAvailablelLenses());
//    	Call call = createAxisCall("http://dev.adaptivedisclosure.org/axis/services/SkosLensWS", "getConceptSchemes");
//	
//    	String[][] result = (String [][]) call.invoke(new Object[] { 
//    			"http://tarski.duhs.org:8080/openrdf-sesame","SNOMED", 
//    			"","",  // user name, password, scheme label
//    			"rdfs:Class", "rdfs:subClassOf", // Lenses
//    			"http://www.w3.org/2004/02/skos/core#Concept", "Not a Virtuoso"
//    			});
//    	//System.out.println(result.length);
//    	for(String [] rows : result) //System.out.println("Check :"+Arrays.toString(rows));
//		
//	}
//	@Test
//	public void testGetTopConceptsSkos2004() throws Exception{
//		////System.out.println(query.getAvailablelLenses());
//		//System.out.println("Testing Get Top Concept Skos 2004");
//		Call call = createAxisCall("http://dev.adaptivedisclosure.org/axis/services/SkosLensWS", "getTopConcepts");
//    	
//    	String[][] result = (String [][]) call.invoke(new Object[] { 
//    			"http://tarski.duhs.org:8080/openrdf-sesame","SNOMED", 
//    			"","", "http://tarski.duhs.org:8080/openrdf-sesame/SNOMED", // user name, password, scheme label
//    			"rdfs:Class", "rdfs:subClassOf", // Lenses
//    			"http://www.w3.org/2004/02/skos/core#Concept", "Not a Virtuoso"
//    			});
//    	//System.out.println(result.length);
//    	for(String [] rows : result) //System.out.println("Check :"+Arrays.toString(rows));
//		
//	}
	
//	@Test
//	public void testGetTopConceptsNonSkos() throws Exception{
//		////System.out.println(query.getAvailablelLenses());
//		//System.out.println("Testing Get Top Concept Non Skos");
//    	Call call = createAxisCall("http://dev.adaptivedisclosure.org/axis/services/SkosLensWS", "getTopConcepts");
//    	
//    	String[][] result = (String [][]) call.invoke(new Object[] { 
//    			"http://dev.adaptivedisclosure.org/openrdf-sesame","tcm", 
//    			"","", "", // user name, password, scheme label
//    			"<http://purl.org/net/tcm/tcm.lifescience.ntu.edu.tw/Medicine>", "<http://purl.org/net/tcm/tcm.lifescience.ntu.edu.tw/association>", // Lenses
//    			"Not Skos", "Not a Virtuoso"
//    			});
//    	//System.out.println(result.length);
//    	//for(String [] rows : result) //System.out.println("Check :"+Arrays.toString(rows));
//		
//	}
//
//	@Test
//	public void testGetTopConceptsNonSkosPredicateOnly() throws Exception{
//		////System.out.println(query.getAvailablelLenses());
//		//System.out.println("Testing Get Top Concept Non Skos with Predicates Only");
//    	Call call = createAxisCall("http://dev.adaptivedisclosure.org/axis/services/SkosLensWS", "getTopConcepts");
//    	
//    	String[][] result = (String [][]) call.invoke(new Object[] { 
//    			"http://tarski.duhs.org:8080/openrdf-sesame","SNOMED", 
//    			"","", "", // user name, password, scheme label
//    			"", "rdfs:subPropertyOf", // Lenses with empty TOP CONCEPT, PREDICATES ONLY
//    			"Not Skos", "Not a Virtuoso"
//    			});
//    	//System.out.println(result.length);
//    	for(String [] rows : result) //System.out.println("Check :"+Arrays.toString(rows));
//		
//	}
	  /** Common routine to setup service call to axis */
    static Call createAxisCall(String axis_service, String operationName) throws Exception {
    	Service service = new Service();
    	Call call = (org.apache.axis.client.Call) service.createCall();
    	call.setTargetEndpointAddress(axis_service);
    	call.setOperationName(operationName);
    	return call;
    }
}
