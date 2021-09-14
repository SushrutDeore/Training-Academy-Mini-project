package com.Bean;

public class Batch {

	private int batchID;
	private String batchName;
	
	public Batch()
	{
		
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	public void setBatch(int id,String name)
	{
		this.setBatchID(id);
		this.setBatchName(name);
		
	}

	@Override
	public String toString() {
		return "batchID=" + this.batchID + ", batchName=" + this.batchName;
	}
	
	
	
}
