package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupsGenerator")
	public void modifySomeGroup(GroupData group) {
		
	    // save old state
		SortedListOf<GroupData> oldList 
			= new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    
	    Random rnd = new Random ();
	    int indexForModify = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    app.getGroupHelper().modifyGroup(indexForModify, group);
		
		// save new state
	    SortedListOf<GroupData> newList 
	    	= new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    
	    // compare states
	    assertThat(newList, equalTo(oldList.without(indexForModify).withAdded(group)));     	    
	}


}
