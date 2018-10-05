
$(document).ready(function(){

    $("input[type=submit").hide();
    $("input[type=text").prop("disabled" , true);
    $("#btn1").click(function(){
        $("input[name=number").prop("disabled" , false);
        $("input[name=find").show();
        $("#topbt").hide();
    });
    $("#btn2").click(function(){
        $("input[type=text").prop("disabled" , false);
        $("input[name=create").show();
        $("#topbt").hide();
    });
    $("#btn3").click(function(){
        $("input[name=number").prop("disabled" , false);
        $("input[name=delete").show();
        $("#topbt").hide();
    });
    $("#btn4").click(function(){
        $("input[type=text").prop("disabled" , false);
        $("input[name=update").show();
        $("#topbt").hide();
    });
});

