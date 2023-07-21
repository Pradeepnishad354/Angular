package com.test.file.response;

public class ResponseFile {
	
	
		private String name;
		private String uri;
		private String type;
		private long size;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public long getSize() {
			return size;
		}
		public void setSize(long size) {
			this.size = size;
		}
		public ResponseFile(String name, String uri, String type, long size) {
			super();
			this.name = name;
			this.uri = uri;
			this.type = type;
			this.size = size;
		}
		

		
		
}


