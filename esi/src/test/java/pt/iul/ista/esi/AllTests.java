package pt.iul.ista.esi;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( { AppTest.class, RegraTest.class } )
public class AllTests 
{
	
}