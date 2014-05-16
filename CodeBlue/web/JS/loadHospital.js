/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var serviceURL = "ws://localhost:8080/CodeBlue/endPoint/loadHospital";
var socket;
var map = 0;
var polylineList = "";

$(document).ready(function() {
    if ("WebSocket" in window) {

        console.log("WebSocket is supported by your browser...");

        socket = new WebSocket(serviceURL);
        socket.binaryType = "arraybuffer";

        socket.onopen = function(evt) {
            console.log("Connection Established! message received: ");
        };

        socket.onclose = function() {
            console.log("Connection Closed!");
        };

        socket.onerror = function(error) {
            console.log("Error Occured: " + error.toString());
        };

        socket.onmessage = function(evt) {
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
//        if(socket.OPEN===1){
//            socket.send("holaa");
//        }
    } else {
        console.log("no connected! :(");
    }
});



$(function() {
    $("#sendFile").click(function() {
        var file = document.getElementById("fileName").files[0];
        console.log("File name:" + file.name);
        socket.send("file Name:" + file.name);
        var reader = new FileReader();
        var rawData = new ArrayBuffer();

        reader.loadend = function() {

        };

        reader.onload = function(e) {
            raawData = e.target.result;
            socket.send(rawData);
            alert("The file has been transfered");
            socket.send("end");
        };

        reader.readAsArrayBuffer(file);
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
                employeList += "<circle id='" + oJson[i].id + "' cx='" + zoneCX + "' cy='" + zoneCY + "' r='5' class='employe' fill='red' stroke='black' stroke-width='1'";
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
                circle.setAttribute("cx",zoneCX);
                circle.setAttribute("cy",zoneCY);
            }
        }
        map = 2;
    }
}

