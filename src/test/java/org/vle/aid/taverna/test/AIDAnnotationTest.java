package org.vle.aid.taverna.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.junit.Test;
import org.vle.aid.taverna.remote.AIDRemoteConfig;
import org.vle.aid.taverna.remote.AIDRemoteQuery;

public class AIDAnnotationTest {
	    
	  
		@Test
		/** 
		 * See : http://www.w3.org/2000/10/annotation-ns
		 */
		public void createAnnotation(){
			AIDRemoteQuery remote = new AIDRemoteQuery(AIDRemoteConfig.DEFAULT_REPOSITORY_SERVICE,
					AIDRemoteConfig.DEFAULT_SESAME_SERVER, "Annotation",	"", "");
			
			// This created annotation should have a generated ID
			String thisAnnotation 	= "http://adaptivedisclosure.org/annotation/"+UUID.randomUUID();
			
			// This should be obtained from the search result
			String thisDocument 	= "http://url.of.the.document#document"; // The thing we will annotate
			
			// This is something from the AIDA Right hand side.
			String thisConcept 		= "http://url.of.the.concept#concept";	// This is the thing we will use to annotate.
			
			// This is obtained from OpenID.
			String thisAnnotator 	= "The annotator";
			
			Calendar cal = Calendar.getInstance();
			String today = cal.getTime().toString();
					
			
			/** Predicates * */
			String annoteaUrl	= "http://www.w3.org/2000/10/annotation-ns#";
			String rdfType 		= "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
			String dcCreator 	= "http://purl.org/dc/elements/1.1/creator";
			String dcDate	 	= "http://purl.org/dc/elements/1.1/date";

			String aAnnotation 	= annoteaUrl + "Annotation";
			String aAnnotates   = annoteaUrl + "annotates";
			String aAuthor	    = annoteaUrl + "author";
			String aBody 	    = annoteaUrl + "body";
			String aContext 	= annoteaUrl + "context";
			String aCreated 	= annoteaUrl + "created";
			String aModified 	= annoteaUrl + "modified";
			String aRelated		= annoteaUrl + "related";
			
			/** Objects * */
			
			

			try {
				// Stating that this annotation is a type of Annotea Annotation
				remote.addRdfStatement(thisAnnotation, rdfType, aAnnotation);
				
				// Stating the author of this annotation
				remote.addRdfStatement(thisAnnotation, aAuthor, thisAnnotator);
				
				// Stating that this annotation is annotating thisDocument
				remote.addRdfStatement(thisAnnotation, aAnnotates, thisDocument);
				
				// Stating that this annotation is created today
				remote.addRdfStatement(thisAnnotation, aCreated, today);
				
				// Stating that this Annotation is related to thisConcept
				remote.addRdfStatement(thisAnnotation, aRelated, thisConcept);
				
				// Stating that this Annotation is related to thisConcept
				remote.addRdfStatement(thisAnnotation, aContext, thisConcept);
				
				// Stating that this Annotation is related to thisConcept
				remote.addRdfStatement(thisAnnotation, aBody, thisConcept);

				
			} catch (Exception e) {
				// Select ?S ?P ?O where {?S ?P ?O}
				e.printStackTrace();			
			}

		}
}
