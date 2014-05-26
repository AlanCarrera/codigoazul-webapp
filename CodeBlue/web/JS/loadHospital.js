/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var serviceLoadHospital = "ws://localhost:8080/CodeBlue/endPoint/loadHospital";
var serviceLoadTeamResponse = "ws://localhost:8080/CodeBlue/endpoint/loadTeamResponse";
var serviceLoadCodeBlueZone = "ws://localhost:8080/CodeBlue/endpoint/loadCodeBlueZone";
var serviceLoadZones = "ws://localhost:8080/CodeBlue/endpoint/loadZones";
var serviceCodeBlueAlertSimluator = "ws://localhost:8080/CodeBlue/endpoint/codeBlueAlertSimulator";
var idCodeBlueAlert = "";
//var socket;
var map = 0;
var polylineList = "";

$(document).ready(function() {
    if ("WebSocket" in window) {

        console.log("WebSocket is supported by your browser...");

        var socketLoadHospital = new WebSocket(serviceLoadHospital);
        socketLoadHospital.binaryType = "arraybuffer";

        socketLoadHospital.onopen = function(evt) {
            console.log("Connection Established! message received: ");
        };

        socketLoadHospital.onclose = function() {
            console.log("Connection Closed!");
        };

        socketLoadHospital.onerror = function(error) {
            console.log("Error Occured: " + error.toString());
        };

        socketLoadHospital.onmessage = function(evt) {
            if (typeof evt.data === "string") {
                console.log("String message received: " + evt.data);
                drawMap(evt.data);
            }
            else if (evt.data instanceof ArrayBuffer) {
                console.log("ArrayBuffer received: " + evt.data);
            }
            else if (evt.data instanceof Blob) {
                console.log("Blob received: " + evt.data);
            }
        };

//        console.log("WebSocket is supported by your browser...");

        var socketLoadTeamResponse = new WebSocket(serviceLoadTeamResponse);
        socketLoadTeamResponse.binaryType = "arraybuffer";

        socketLoadTeamResponse.onopen = function(evt) {
            console.log("Connection Established! message received: ");
        };

        socketLoadTeamResponse.onclose = function() {
            console.log("Connection Closed!");
        };

        socketLoadTeamResponse.onerror = function(error) {
            console.log("Error Occured: " + error.toString());
        };

        socketLoadTeamResponse.onmessage = function(evt) {
            if (typeof evt.data === "string") {
                console.log("String message received: " + evt.data);
                var oJson = jQuery.parseJSON(evt.data);
                for (var i = 0; i < oJson.length; i++) {
                    var circle = document.getElementById(oJson[i].id);
                    circle.setAttribute("fill", "blue");
                }
            }
            else if (evt.data instanceof ArrayBuffer) {
                console.log("ArrayBuffer received: " + evt.data);
            }
            else if (evt.data instanceof Blob) {
                console.log("Blob received: " + evt.data);
            }
        };

        var socketLoadCodeBlueZone = new WebSocket(serviceLoadCodeBlueZone);
        socketLoadCodeBlueZone.binaryType = "arraybuffer";

        socketLoadCodeBlueZone.onopen = function(evt) {
            console.log("Connection Established! message received: ");
        };

        socketLoadCodeBlueZone.onclose = function() {
            console.log("Connection Closed!");
        };

        socketLoadCodeBlueZone.onerror = function(error) {
            console.log("Error Occured: " + error.toString());
        };

        socketLoadCodeBlueZone.onmessage = function(evt) {
            if (typeof evt.data === "string") {
                console.log("String message received: " + evt.data);
                var cb = "";
                var oJson = jQuery.parseJSON(evt.data);
                idCodeBlueAlert = oJson.name;
                var zoneCX = ((oJson.xesi + oJson.xeid) / 2) * 6;
                var zoneCY = ((oJson.yesi + oJson.yeid) / 2) * 6;
                cb += "<circle id='" + oJson.name + "' cx='" + zoneCX + "' cy='" + zoneCY + "' r='5' class='employe' fill='blue'";
                cb += "' ></circle>\n";
                polylineList += cb;
                document.getElementById("SVGCanvas").innerHTML = polylineList;
                $("#" + idCodeBlueAlert).everyTime(10, function() {
                    var cb = $("#" + idCodeBlueAlert);
                    cb.fadeIn(400);
                    cb.animate({height: '10px', width: '10px', opacity: '0.3'}, "slow");
                    cb.slideToggle(300).delay(800);
                    cb.attr({
                        r: 5,
                        opacity: 1
                    });
//                    cb.slideUp( 300 ).delay( 800 ).fadeIn( 400 );
//                    cb.animate({r: '10px', opacity:'0.3'},"slow");
                });

//                    window.clearTimeout(timeoutID);

            }
            else if (evt.data instanceof ArrayBuffer) {
                console.log("ArrayBuffer received: " + evt.data);
            }
            else if (evt.data instanceof Blob) {
                console.log("Blob received: " + evt.data);
            }
        };

        var socketLoadZones = new WebSocket(serviceLoadZones);
        socketLoadZones.binaryType = "arraybuffer";

        socketLoadZones.onopen = function(evt) {
            console.log("Connection Established! message received: ");
        };

        socketLoadZones.onclose = function() {
            console.log("Connection Closed!");
        };

        socketLoadZones.onerror = function(error) {
            console.log("Error Occured: " + error.toString());
        };

        socketLoadZones.onmessage = function(evt) {
            if (typeof evt.data === "string") {
                console.log("String message received: " + evt.data);
                var oJson = jQuery.parseJSON(evt.data);
                for (var i = 0; i < oJson.length; i++) {
                    var newOption = $("<option />",
                            {
                                value: oJson[i].id,
                                text: oJson[i].name
                            });
                    $("#zone-selected").append(newOption);
                }
            }
            else if (evt.data instanceof ArrayBuffer) {
                console.log("ArrayBuffer received: " + evt.data);
            }
            else if (evt.data instanceof Blob) {
                console.log("Blob received: " + evt.data);
            }
        };
        
        var socketCodeBlueAlertSimluator = new WebSocket(serviceCodeBlueAlertSimluator);
        socketCodeBlueAlertSimluator.binaryType = "arraybuffer";

        socketCodeBlueAlertSimluator.onopen = function(evt) {
            console.log("Connection Established! message received: ");
        };

        socketCodeBlueAlertSimluator.onclose = function() {
            console.log("Connection Closed!");
        };

        socketCodeBlueAlertSimluator.onerror = function(error) {
            console.log("Error Occured: " + error.toString());
        };

        socketCodeBlueAlertSimluator.onmessage = function(evt) {
            if (typeof evt.data === "string") {
                console.log("String message received: " + evt.data);
            }
            else if (evt.data instanceof ArrayBuffer) {
                console.log("ArrayBuffer received: " + evt.data);
            }
            else if (evt.data instanceof Blob) {
                console.log("Blob received: " + evt.data);
            }
        };

        
//        if(socket.OPEN===1){
//            socket.send("holaa");
//        }
    } else {
        console.log("no connected! :(");
    }

    $("#boton-parar-alerta").click(function() {
        $("#" + idCodeBlueAlert).stop(true).stopTime();
        $("#" + idCodeBlueAlert).remove();
    });

    $("#lanzar-alerta").click(function() {
        var idzona = $("#zone-selected").find(":selected").val();
        socketCodeBlueAlertSimluator.send(idzona);
    });
});



function drawMap(json) {
//    $.getJSON(json, function (content){
//        var polylineList = "<g transform='scale(6)'>\n";
//        $.each(json, function (index, polyline){
//            polylineList += "<polyline id=" + polyline.name + " class='zone' fill='none' stroke='#333333' stroke-width='1.4173' stroke-linecap='round' stroke-linejoin='round' stroke-miterlimit='10' points=" + polyline.coordenadas + "/>";
//        });

//    });


    if (map == 0) {
        map = 1;
        var oJson = jQuery.parseJSON(json);
//    var polyline = "";
//    <polyline class="zone" fill="none" stroke="#333333" stroke-width="1.4173" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" points="
//                          6.7,799.5 81.3,799.5 81.3,716.4 6.7,716.4 6.7,799.5 	"/>
        for (var i = 0; i < oJson.length; i++) {
            polylineList += "<polyline id='" + oJson[i].nombre + "' class='zone' fill='none' stroke='#333333' stroke-width='1.4173' stroke-linecap='round' stroke-linejoin='round' stroke-miterlimit='10' points=' ";
            var coords = oJson[i].coordenadas;
            for (var j = 0; j < coords.length; j++) {
                polylineList += coords[j].x + "," + coords[j].y + " ";
                if ((coords.length - j) == 1) {
                    polylineList += coords[0].x + "," + coords[0].y + " ";
                }
            }
            polylineList += "' ></polyline>\n";
        }
//    polylineList += "</g>";
        document.getElementById("SVGCanvas").innerHTML = polylineList;

    } else {
        var employeList = "";
        var oJson = jQuery.parseJSON(json);
        if (map == 1) {
            //<circle cx="50" cy="50" r="40" stroke="black" stroke-width="3" fill="red" />
            for (var i = 0; i < oJson.length; i++) {
                var zoneCX = ((oJson[i].zone.xesi + oJson[i].zone.xeid) / 2) * 6;
                var zoneCY = ((oJson[i].zone.yesi + oJson[i].zone.yeid) / 2) * 6;
                employeList += "<circle id='" + oJson[i].id + "' cx='" + zoneCX + "' cy='" + zoneCY + "' r='4' class='employe' fill='red'";
                employeList += "' ></circle>\n";
            }
            polylineList += employeList;
            document.getElementById("SVGCanvas").innerHTML = polylineList;

        } else {
            for (var i = 0; i < oJson.length; i++) {
                var zoneCX = ((oJson[i].zone.xesi + oJson[i].zone.xeid) / 2) * 6;
                var zoneCY = ((oJson[i].zone.yesi + oJson[i].zone.yeid) / 2) * 6;
                var circle = document.getElementById(oJson[i].id);
//                document.getElementById(oJson[i].id).cy=zoneCY;
                circle.setAttribute("cx", zoneCX);
                circle.setAttribute("cy", zoneCY);
            }
        }
        map = 2;
    }
}



