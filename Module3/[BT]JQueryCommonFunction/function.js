$(document).ready(function() {
    $("#draggable").draggable();
    $("#droppable").droppable({
        drop: function(event, ui) {
            $(this)
                .addClass("ui-state-highlight")
                .find("p")
                .html("Dropped!");
        }
    });

    $("#resizable").resizable();

    $("#selectable").selectable();

    $("#sortable").sortable();

    $("#sortable").disableSelection();

    $("#accordion").accordion();

    var availableTags=[
        "ActionScript",
        "AppleScript",
        "Asp",
        "BASIC",
        "C",
        "C++",
        "Clojure",
        "COBOL",
        "ColdFusion",
        "Erlang",
        "Fortran",
        "Groovy",
        "Haskell",
        "Java",
        "JavaScript",
        "Lisp",
        "Perl",
        "PHP",
        "Python",
        "Ruby",
        "Scala",
        "Scheme"
    ];

    $("#tags").autocomplete({
        source: availableTags
    });

    $("#datepicker").datepicker();

    //spinner
    var spinner = $("#spinner").spinner();

    $("#disable").on("click",function(){
        if(spinner.spinner("option","disable")){
            spinner.spinner("enable");
        }else{
            spinner.spinner("disable");
        }
    });

    $("#destroy").on("click",function(){
        if(spinner.spinner("instance")){
            spinner.spinner("destroy");
        }else{
            spinner.spinner();
        }
    });

    $("#getvalue").on("click",function(){
        alert(spinner.spinner("value"));
    });

    $("#setvalue").on("click",function(){
        spinner.spinner("value",5);
    });

    $("button").button();

    $("#tabs").tabs();
    
});
