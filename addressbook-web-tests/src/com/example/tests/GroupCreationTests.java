package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
@DataProvider
	public Iterator<Object[]> groupsFromFile () throws IOException {
		return wrapGroupsForProvider(loadGroupFromXmlFile(new File ("groups.xml"))).iterator();
	}

@Test(dataProvider = "groupsFromFile")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	
	// save old state
	  SortedListOf<GroupData> oldList 
	  	= new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
    
    // actions    
    app.getGroupHelper().createGroup(group);    
    
    // save new state
    SortedListOf<GroupData> newList
    = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(group)));     
  }  
  
}
