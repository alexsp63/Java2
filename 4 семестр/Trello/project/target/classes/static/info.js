$(document).ready(function () {
/*
    $("#signUp").click(function () {
        $.ajax({
            url:"http://localhost:8080/api/user",
            type: "GET",
            dataType: "json",
            success: function (response) {
                console.log(response);
            },
            error: function (response){
                console.log(response);

            }
        });

    });

 */

    $("#save").click(async function (){
        let varData = {
            "firstName": $("#firstName").val(),
            "lastName": $("#lastName").val(),
            "middleName": $("#middleName").val(),
            "login": $("#login").val(),
            "passwordHash": $("#password").val(),
            "newPasswordHash": $("#newpassword").val()
        };
        console.log(varData);
        /*
        let response = await fetch ("http://localhost:8080/api/user/", {
            method: "PUT",
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(varData)
        });
        console.log(response)

         */
    });
})