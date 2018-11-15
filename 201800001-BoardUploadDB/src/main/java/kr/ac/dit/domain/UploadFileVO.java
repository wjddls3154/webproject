package kr.ac.dit.domain;

public class UploadFileVO {
	  private int fileId;

	  private String fileName;

	  public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	private byte[] fileData;

	  // Getters and Setters
}
