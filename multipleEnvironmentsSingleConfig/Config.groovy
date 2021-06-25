//Define common properties accross all the environments or any other constants needed
common {
	USER='engineer1'
}

//Define the environments 
environment {
    qa {
    	//Define software release version wise configuration       
    	'r1' {
    		SERVICE_HOST = 'r1.host1.com'
			SERVICE_PORT = 8443
			DB_HOST = 'r1.testdb.com'
    	}
    	'r1.1' {
    		SERVICE_HOST = 'r1.host1.com'
			SERVICE_PORT = 8445
			DB_HOST = 'r1.testdb.com'
    	}
    }
    staging {
    	'r1' {
    		SERVICE_HOST = 'r1.staging.host1.com'
			SERVICE_PORT = 8443
			DB_HOST = 'r1.stagingdb.com'
    	}
    	'r1.1' {
    		SERVICE_HOST = 'r1.staging.host1.com'
			SERVICE_PORT = 8445
			DB_HOST = 'r1.stagingdb.com'
    	}
    }
}
