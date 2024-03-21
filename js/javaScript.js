const admin = require("C:\\Users\\Coralie\\Documents\\Informatique mobile\\Travail_de_fin_session\\firebase-admin");

/*
GET /users: Retrieve a list of users from the database.
POST /users: Create a new user in the database.
GET /users/{id}: Retrieve a specific user by ID.
PUT /users/{id}: Update an existing user.
DELETE /users/{id}: Delete a user by ID.
*/

function getAccessToken() {
    return admin.credential.applicationDefault().getAccessToken()
        .then(accessToken => {
            return accessToken.access_token;
        })
        .catch(err => {
            console.error('Unable to get access token');
            console.error(err);
        });
}

