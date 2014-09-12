/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var serviceLoadHospital = "ws://localhost:8080/CodeBlue/endPoint/loadHospital";
var serviceLoadTeamResponse = "ws://localhost:8080/CodeBlue/endpoint/loadTeamResponse";
var serviceLoadCodeBlueZone = "ws://localhost:8080/CodeBlue/endpoint/loadCodeBlueZone";
//var serviceLoadZones = "ws://localhost:8080/CodeBlue/endpoint/loadZones";
var serviceCodeBlueAlertSimluator = "ws://localhost:8080/CodeBlue/endpoint/codeBlueAlertSimulator";
var serviceAdmorDatosWS = "ws://localhost:8080/CodeBlue/endpoint/AdmorDatosWS";

//Sockets
var socketLoadHospital;
var socketLoadTeamResponse;
var socketLoadCodeBlueZone;
//var socketLoadZones;
var socketCodeBlueAlertSimluator;
var socketAdmorDatosWS;

var idCodeBlueAlert = "";
var map = 0;
var polylineList = "";
var equipoRespuesta;

$(document).ready(function() {
    if ("WebSocket" in window) {

        console.log("WebSocket is supported by your browser...");

        socketLoadHospital = new WebSocket(serviceLoadHospital);
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

        socketLoadTeamResponse = new WebSocket(serviceLoadTeamResponse);
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
                equipoRespuesta = jQuery.parseJSON(evt.data);
                for (var i = 0; i < equipoRespuesta.length; i++) {
                    var circle = document.getElementById(equipoRespuesta[i].id);
                    circle.classList.toggle('icon-team');
                }
            }
            else if (evt.data instanceof ArrayBuffer) {
                console.log("ArrayBuffer received: " + evt.data);
            }
            else if (evt.data instanceof Blob) {
                console.log("Blob received: " + evt.data);
            }
        };

        socketLoadCodeBlueZone = new WebSocket(serviceLoadCodeBlueZone);
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
                document.getElementById("viewport").innerHTML = polylineList;
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

        //Se quito el loadzones pq se reemplazo
//        socketLoadZones = new WebSocket(serviceLoadZones);
//        socketLoadZones.binaryType = "arraybuffer";
//
//        socketLoadZones.onopen = function(evt) {
//            console.log("Connection Established! message received: ");
//        };
//
//        socketLoadZones.onclose = function() {
//            console.log("Connection Closed!");
//        };
//
//        socketLoadZones.onerror = function(error) {
//            console.log("Error Occured: " + error.toString());
//        };
//
//        socketLoadZones.onmessage = function(evt) {
//            if (typeof evt.data === "string") {
//                console.log("String message received: " + evt.data);
//                var oJson = jQuery.parseJSON(evt.data);
//                for (var i = 0; i < oJson.length; i++) {
//                    var newOption = $("<option />",
//                            {
//                                value: oJson[i].id,
//                                text: oJson[i].name
//                            });
//                    $("#zone-selected").append(newOption);
//                }
//            }
//            else if (evt.data instanceof ArrayBuffer) {
//                console.log("ArrayBuffer received: " + evt.data);
//            }
//            else if (evt.data instanceof Blob) {
//                console.log("Blob received: " + evt.data);
//            }
//        };

        socketCodeBlueAlertSimluator = new WebSocket(serviceCodeBlueAlertSimluator);
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
                var oJson = jQuery.parseJSON(evt.data);
                setAlertaCodigoAzulServidor(oJson);
            }
            else if (evt.data instanceof ArrayBuffer) {
                console.log("ArrayBuffer received: " + evt.data);
            }
            else if (evt.data instanceof Blob) {
                console.log("Blob received: " + evt.data);
            }
        };

        socketAdmorDatosWS = new WebSocket(serviceAdmorDatosWS);
        socketAdmorDatosWS.binaryType = "arraybuffer";

        socketAdmorDatosWS.onopen = function(evt) {
            console.log("Connection Established! message received: ");
        };

        socketAdmorDatosWS.onclose = function() {
            console.log("Connection Closed!");
        };

        socketAdmorDatosWS.onerror = function(error) {
            console.log("Error Occured: " + error.toString());
        };

        socketAdmorDatosWS.onmessage = function(evt) {
            if (typeof evt.data === "string") {
                console.log("String message received: " + evt.data);
                var oJson = jQuery.parseJSON(evt.data);
                if (oJson.nombreMensaje == "getZonasArea") {
                    cargarZonasComboBox(oJson);
                } else if (oJson.nombreMensaje == "getDetallePersonal") {
                    mostrarDetallePersonal(oJson);
                }
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
        $("circle").each(function(i) {
            $(this).attr({fill: "red"});
        });
    });

    /**
     * Escucha cuando una zona del plano a sido seleccionada, por consecuente, 
     * envia un mensaje a AdmorDatosWS el cual devuelve todas las zonas de esa zona del plano.
     */
//    $('polyline[class~="zone"]').click(function() {
//        var zonaSeleccionada = $(this).val();
//    });

    /*
     * Escucha cuando se activa la alerta de codigo azul desde el boton id="lanzar-alerta".
     */
//    $("#lanzar-alerta").click(function() {
//        var idzona = $("#zone-selected").find(":selected").val(); //busca la zona que fue seleccionada.
////        socketCodeBlueAlertSimluator.send(idzona);
//        //Crea el mensaje que se enviara.
//        var mensajeJSON = new Object();
//        mensajeJSON.nombreMensaje = "prueba"; //Nombre del metodo que procesara el mensaje.
//        mensajeJSON.mensaje = "ola"; //mensaje que procesara.
//        //Crea el objeto JSON y lo envia hacia un WebSocket Endpoint.
//        socketAdmorDatosWS.send(JSON.stringify(mensajeJSON));
//    });
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
            polylineList += "<polyline id='" + oJson[i].nombre + "' class='zone' onClick='zonaSeleccionada(this)' points=' ";
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
        document.getElementById("viewport").innerHTML = polylineList;

    } else {
        var employeList = "";
        var oJson = jQuery.parseJSON(json);
        if (map == 1) {
            //<circle cx="50" cy="50" r="40" stroke="black" stroke-width="3" fill="red" />
            for (var i = 0; i < oJson.length; i++) {
                var zoneCX = ((oJson[i].zone.xesi + oJson[i].zone.xeid) / 2) * 6;
                var zoneCY = ((oJson[i].zone.yesi + oJson[i].zone.yeid) / 2) * 6;
//                employeList += "<circle id='" + oJson[i].id + "' cx='" + zoneCX + "' cy='" + zoneCY + "' r='4' class='employe' fill='red'";
//                employeList += "' ></circle>\n";
                if (oJson[i].position.id == 8) {
                    employeList += "<use id='" + oJson[i].id + "' class='icon-car' width='15px' heigth='15px' x='" + (zoneCX - 7.5) + "' y='" + (zoneCY - 7.5) + "' xlink:href='#icon-car' onClick='getDetallePersonal(this)'/>\n";
                } else if (oJson[i].position.id == 7) {
                    employeList += "<use id='" + oJson[i].id + "' class='icon-nurse' width='15px' heigth='15px' x='" + (zoneCX - 7.5) + "' y='" + (zoneCY - 7.5) + "' xlink:href='#icon-nurse' onClick='getDetallePersonal(this)'/>\n";
                } else {
                    employeList += "<use id='" + oJson[i].id + "' class='icon-doctor' width='15px' heigth='15px' x='" + (zoneCX - 7.5) + "' y='" + (zoneCY - 7.5) + "' xlink:href='#icon-doctor' onClick='getDetallePersonal(this)' />\n";
                }
            }
            polylineList += employeList + "\n";

            //se agrega al final el icono del corazon.
            polylineList += "<g id='heart-map' transform='translate(-150,-150)'> ";
            polylineList += " <path class='icon-animated icon-heart-map' d='M211.001,134.484c0.1,1.232,0.166,2.486,0.166,3.779c0,26.437-34.414,64.086-61.379,83.918 ";
            polylineList += "c-26.965-19.832-61.378-57.481-61.378-83.918c0-0.595,0.052-1.159,0.076-1.739c-0.071-0.882-0.204-1.782-0.204-2.641";
            polylineList += "c0-26.442,21.572-40.238,35.954-40.238c14.382,0,23.113,9.199,25.425,12.933c2.312-3.734,11.043-12.933,25.425-12.933";
            polylineList += "s35.954,13.796,35.954,40.238c0,0.229-0.049,0.473-0.055,0.704C210.988,134.552,210.998,134.517,211.001,134.484z M190.579,139.439";
            polylineList += "c-0.463,0-0.911,0.07-1.345,0.177c-3.454,0.814-4.222,3.176-8.789,3.176h-20.481l-3.413-15.122c-0.803-3.595-3.413-3.78-3.413-3.78";
            polylineList += "c-0.947,0.011-3.212,2.555-3.425,3.586l-3.402,19.097l-3.413-11.341c-0.278-0.934-2.585-0.373-3.467-0.373";
            polylineList += "c-0.881,0,0.333-0.562,0.053,0.373l-3.787,7.223l-3.04-22.344c-0.475,0-6.678-1.109-6.827,0l-3.413,37.805l-6.827-15.122";
            polylineList += "c-0.362-0.729-2.67,0-3.413,0h-10.24c-1.131,0-1.946,2.411-1.39,3.514c1.267,2.515,0.958,3.07,4.803,4.047h6.827l10.24,18.902h6.827";
            polylineList += "V135.23l4.101,16.189c0.206,1,0.981,1.724,1.898,1.773c0.016,0,0.032,0,0.048,0c0.875,0,1.706-0.608,1.99-1.565l2.203-5.056";
            polylineList += "l4.145,11.906c0.28,0.944,1.041,1.568,1.956,1.568c0.028,0,0.054-0.002,0.082-0.002c0.915-0.049,1.691-0.773,1.896-1.773";
            polylineList += "l4.224-20.483l2.028,9.076c0.228,1.017,1.798,3.49,2.737,3.49h23.894h-3.413c4.571,0,8.752,1.838,12.213,2.648";
            polylineList += "c0.394,0.098,0.799,0.152,1.219,0.161l0.116,0.013c3.389,0,6.138-3.077,6.138-6.869S193.968,139.439,190.579,139.439z'/>";
            polylineList += "</g>";
            document.getElementById("viewport").innerHTML = polylineList;

        } else {
            for (var i = 0; i < oJson.length; i++) {
                var zoneCX = ((oJson[i].zone.xesi + oJson[i].zone.xeid) / 2) * 6;
                var zoneCY = ((oJson[i].zone.yesi + oJson[i].zone.yeid) / 2) * 6;
                var circle = document.getElementById(oJson[i].id);
//                document.getElementById(oJson[i].id).cy=zoneCY;
                circle.setAttribute("x", zoneCX - 7.5);
                circle.setAttribute("y", zoneCY - 7.5);
            }
        }
        map = 2;
    }
}

/**
 * Escucha cuando una zona del plano a sido seleccionada, por consecuente, 
 * envia un mensaje a AdmorDatosWS el cual devuelve todas las zonas de esa zona del plano.
 * NOTA: No es posible seleccionar los elementos SVG a travez de JQuery,
 * por lo que se tiene que hacer directamente desde JavaScript.
 * 
 * @param {type} elemento elemento zona del plano hospitalario.
 * @returns {undefined}
 */
function zonaSeleccionada(elemento) {
    //obtiene el id de la zona seleccionada.
    var zonaSeleccionada = elemento.id;
    //Crea el mensaje que se enviara.
    var mensajeJSON = new Object();
    mensajeJSON.nombreMensaje = "getZonasArea"; //Nombre del metodo que procesara el mensaje.
    mensajeJSON.mensaje = "" + zonaSeleccionada; //mensaje que procesara.
    //Crea el objeto JSON y lo envia hacia un WebSocket Endpoint.
    socketAdmorDatosWS.send(JSON.stringify(mensajeJSON));
}

/**
 * Este metodo carga las zonas al elemento comboBox o tag select, el cual muestra
 * las Aonas de la Zona seleccionada en el Plano.
 * 
 * @param {type} json lista de Zonas en formato JSON.
 * @returns {undefined} llena el elemento select con las Zonas.
 */
function cargarZonasComboBox(json) {
    var listaZona = json.listaZona;
    $("#zone-selected option").remove(); //Remueve las zonas que esten dentro.
    $("#zone-selected").append("<option>Seleccionar Zona...</option>"); //Agrega el primer elemento por default.
    for (var i = 0; i < listaZona.length; i++) {
        var newOption = $("<option />",
                {
                    value: listaZona[i].id,
                    text: listaZona[i].name
                }); //Forma cada uno de los option.
        $("#zone-selected").append(newOption); //Agrega los option al elemento select.
    }
}

/**
 * Este metodo escucha cuando la alerta de codigo azul es activada o desactivada.
 * 
 * @param {type} elemento elemento SVG conrazon azul que se activa o desactiva.
 * @returns {undefined} 
 */
function setAlertaCodigoAzul(elemento) {
    var statusCorazon = elemento.className.baseVal;
    //statusCorazon: apagado = 'clicked', encendido = ''.
    if (statusCorazon == '') {
//        var idZona = $("#zone-selected").find(":selected").val(); //busca la zona que fue seleccionada.
//        if (idZona != 'Seleccionar Zona...') {
//            //Crea el mensaje que se enviara.
//            var mensajeJSON = new Object();
//            mensajeJSON.nombreMensaje = "setAlertaCodigoAzul"; //Nombre del metodo que procesara el mensaje.
//            mensajeJSON.mensaje = "encenderAlerta"; //mensaje que procesara.
//            mensajeJSON.idZona = idZona;
//            //Crea el objeto JSON y lo envia hacia un WebSocket Endpoint.
//            socketCodeBlueAlertSimluator.send(JSON.stringify(mensajeJSON));
//        } else {
//            alert("Es necesario seleccionar alguna zona.\n\
//                    Por favor selecciona una.")
//        }
    } else if (statusCorazon == 'clicked') {
//Crea el mensaje que se enviara.
        var mensajeJSON = new Object();
        mensajeJSON.nombreMensaje = "setAlertaCodigoAzul"; //Nombre del metodo que procesara el mensaje.
        mensajeJSON.mensaje = "apagarAlerta"; //mensaje que procesara.
        //deshabilitar alerta personal.
        for (var i = 0; i < equipoRespuesta.length; i++) {
            var circle = document.getElementById(equipoRespuesta[i].id);
            circle.classList.toggle('icon-team');
        }
        //Crea el objeto JSON y lo envia hacia un WebSocket Endpoint.
        socketCodeBlueAlertSimluator.send(JSON.stringify(mensajeJSON));
    }
}

/**
 * Este metodo activa o desactiva la alerta de codigo azul con una notificacion desde el
 * servidor de aplicaciones.
 * 
 * @param {type} json mensaje del servidor.
 * @returns {undefined} activa o desactiva la alerta.
 */
function setAlertaCodigoAzulServidor(json) {
    var statusCodigoAzul = json.nombreMensaje;
    if (statusCodigoAzul == "encenderAlerta") {
        var cCodigoAzul = document.getElementById("heart");
        cCodigoAzul.classList.toggle('clicked');
        //Corazon dentro del mapa
        var cCodigoAzulMapa = document.getElementById("heart-map");
        cCodigoAzulMapa.classList.toggle('activated');
        //Cambiar coordenadas de corazon en mapa.
        var zoneCX = (((json.zonaAlerta.xesi + json.zonaAlerta.xeid) / 2) * 6) - 150;
        var zoneCY = (((json.zonaAlerta.yesi + json.zonaAlerta.yeid) / 2) * 6) - 150;
        var s = "translate(" + zoneCX + "," + zoneCY + ")";
        cCodigoAzulMapa.setAttribute("transform", s);
        $("#zona-alerta").empty();
        var fecha = new Date();
        hora = fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds();
        $("#zona-alerta").append(json.zonaAlerta.name + " - " + hora);
    }
    else if (statusCodigoAzul == "apagarAlerta") {
        var cCodigoAzul = document.getElementById("heart");
        cCodigoAzul.classList.toggle('clicked');
        //Corazon dentro del mapa
        var cCodigoAzulMapa = document.getElementById("heart-map");
        cCodigoAzulMapa.classList.toggle('activated');
    }
}

function getDetallePersonal(elemento) {
    var idPersonal = elemento.id;
    var mensajeJSON = new Object();
    mensajeJSON.nombreMensaje = "getDetallePersonal";
    mensajeJSON.mensaje = "" + idPersonal;
    socketAdmorDatosWS.send(JSON.stringify(mensajeJSON));
}

function mostrarDetallePersonal(json) {
    $("#info-detalle").empty();
    $("#info-detalle").append($("<label />",
            {
                value: json.personal.nombre,
                text: json.personal.nombre
            }));
    $("#info-detalle").append("<label class='ref'>Nombre</label>");
    $("#info-detalle").append($("<label />",
            {
                value: json.personal.position.name,
                text: json.personal.position.name
            }));
    $("#info-detalle").append("<label class='ref'>Puesto</label>");
    $("#info-detalle").append($("<label />",
            {
                value: json.personal.dispositivo,
                text: json.personal.dispositivo
            }));
    $("#info-detalle").append("<label class='ref'># Dispositivo</label>");
    $("#info-detalle").append($("<label />",
            {
                value: json.personal.zone.name,
                text: json.personal.zone.name
            }));
    $("#info-detalle").append("<label class='ref'>Ubicaci&oacute;n</label>");
}




