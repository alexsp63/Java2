$(document).ready(function () {

    $("#signIn").click(async function (){
        let varData = {
            "username": $("#login").val(),
            "password": $("#password").val()
        };
        console.log(varData);
        let response = await fetch ("http://localhost:8080/api/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(varData)
        });
        console.log(response)
    });
})