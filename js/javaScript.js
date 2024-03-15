const admin = require("C:\\Users\\Coralie\\Documents\\Informatique mobile\\Travail_de_fin_session\\firebase-admin");

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

