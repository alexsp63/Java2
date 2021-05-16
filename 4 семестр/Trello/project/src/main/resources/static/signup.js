$(document).ready(function () {
    $("#signUp").click(async function (){
        let varData = {
            "login": $("#login").val(),
            "firstName": $("#firstName").val(),
            "lastName": $("#lastName").val(),
            "middleName": $("#middleName").val(),
            "passwordHash": $("#password").val(),
            "role": "USER",
            "status": "ACTIVE"
        };
        console.log(varData);
        let response = await fetch ("http://localhost:8080/api/user", {
            method: "POST",
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(varData)
        });
        console.log(response)
    });

})