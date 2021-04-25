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
    $("#signUp").click(async function (){
        let varData = {
            "login": $("#login"),
            "firstName": $("#firstName"),
            "lastName": $("#lastName"),
            "password": $("#password")
        };
        console.log(varData);
        let response = await fetch ("http://localhost:8080/api/user", {
            mode: "no-cors",
            method: "POST",
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(varData)
        });
        console.log(response)
    });

})