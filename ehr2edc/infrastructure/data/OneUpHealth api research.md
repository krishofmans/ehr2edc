# One up health api exploration

There is temporal coupling between getting a token, and then using that token to get an oauth token. It need to happen in a small timeframe, can only happen once, then the oauth token is valid for 7200 seconds.

Testing with the up and running application is manual for now, configure the url to go to: http://api.1up.health (as it doesn't seem to like the ssl certificate) thankfully http is also functional, and replace the hardcoded token in the `OneUpHealthBearerTokenInterceptor`.

## Get all connected sites
curl "https://api.1up.health/connect/system/clinical?client_id=6ea2c41c75c445f2ac2bbd1a82326866&client_secret=hR2bBdpq9tUlUp1ZCIz06U22ErWVknVU" \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## create user
curl -X "POST" "https://api.1up.health/user-management/v1/user" \
     -H 'Content-Type: application/x-www-form-urlencoded; charset=utf-8' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## get all users
curl "https://api.1up.health/user-management/v1/user" \
     -H 'Content-Type: application/x-www-form-urlencoded; charset=utf-8' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## get token
curl -X "POST" "https://api.1up.health/user-management/v1/user/auth-code" \
     -H 'Content-Type: application/x-www-form-urlencoded; charset=utf-8' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## get oauth token
curl -X "POST" "https://api.1up.health/fhir/oauth2/token" \
     -H 'Content-Type: application/x-www-form-urlencoded; charset=utf-8' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## connect to ehr
curl "https://api.1up.health/connect/system/clinical/4706?client_id=02a8d815d9a6442fb4b387d7a20e7f80&access_token=d82e471b63fd4f2f99e7b7c4f865d94c" \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## connect to ehr
curl "https://api.1up.health/connect/system/clinical/4707?client_id=02a8d815d9a6442fb4b387d7a20e7f80&access_token=d82e471b63fd4f2f99e7b7c4f865d94c" \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## create patient
curl -X "POST" "https://api.1up.health/fhir/dstu2/Patient" \
     -H 'Content-Type: application/json' \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6' \
     -d $'{
  "gender": "male",
  "id": "135376",
  "resourceType": "Patient",
  "meta": {
    "versionId": "1",
    "lastUpdated": "2017-05-26T12:00:41.233-04:00"
  },
  "name": [
    {
      "use": "official",
      "family": [
        "Baggins"
      ],
      "given": [
        "Bilbo"
      ],
      "text": "Bilbo Baggins123"
    }
  ],
  "birthDate": "1993-06-20"
}'

## get demographics
curl "https://api.1up.health/fhir/dstu2/Patient/" \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## get medication
curl "https://api.1up.health/fhir/dstu2/Medication/" \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## get observations
curl "https://api.1up.health/fhir/dstu2/Observation" \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## get condition
curl "https://api.1up.health/fhir/dstu2/Condition" \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## get NamingSystem
curl "https://api.1up.health/fhir/dstu2/NamingSystem" \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## metadata
curl "https://api.1up.health/fhir/dstu2/metadata" \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c' \
     -H 'Cookie: AWSALB=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6; AWSALBCORS=4we9jI2kjIvz6pc4BfHrTS0oTx7BxwHmdhrTj96n4cMNwp7zocfWklpjsW4oXl16wivywZfxyba4jlEK9FFXLGmf0onqpN3JLvSMOR4Et732RbBGh056ZB/fLbL6'

## reproduced issue with multiple authorization headers
curl "https://api.1up.health/fhir/dstu2/metadata" \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c,Bearer d82e471b63fd4f2f99e7b7c4f865d94c' \
     -H 'Accept: application/xml+fhir;q=1.0, application/json+fhir;q=1.0' \
     -H 'User-Agent: HAPI-FHIR/4.0.3 (FHIR Client; FHIR 1.0.2/DSTU2; apache)' \
     -H 'Accept-Encoding: gzip' \
     -H 'Accept-Charset: utf-8'

## metadata by hapi sandbox
curl "http://hapifhir-r2.custodix.tech/baseDstu2/metadata" \
     -H 'Accept: application/xml+fhir;q=1.0, application/json+fhir;q=1.0' \
     -H 'User-Agent: HAPI-FHIR/4.0.3 (FHIR Client; FHIR 1.0.2/DSTU2; apache)' \
     -H 'Accept-Encoding: gzip' \
     -H 'Accept-Charset: utf-8' \
     -H 'Authorization: Bearer d82e471b63fd4f2f99e7b7c4f865d94c'
