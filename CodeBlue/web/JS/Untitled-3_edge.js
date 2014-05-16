/**
 * Adobe Edge: symbol definitions
 */
(function($, Edge, compId){
//images folder
var im='images/';

var fonts = {};
var opts = {};
var resources = [
];
var symbols = {
"stage": {
    version: "3.0.0",
    minimumCompatibleVersion: "3.0.0",
    build: "3.0.0.322",
    baseState: "Base State",
    scaleToFit: "none",
    centerStage: "none",
    initialState: "Base State",
    gpuAccelerate: false,
    resizeInstances: false,
    content: {
            dom: [
            {
                id: 'senal',
                type: 'image',
                rect: ['315px', '338px','148px','94px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"senal.png",'0px','0px'],
                filter: [0, 0, 1.44, 6.3333333333333, 0, 0, 0, 0, "rgba(13,0,213,0.00)", 0, 0, 0]
            },
            {
                id: 'CB_Logo',
                type: 'image',
                rect: ['463px', '357px','287px','61px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"codigo%20azul%20-%20logo2.png",'0px','0px']
            },
            {
                id: 'Rectangle6',
                type: 'rect',
                rect: ['449px', '384px','19px','4px','auto', 'auto'],
                fill: ["rgba(103,139,255,1)"],
                stroke: [0,"rgba(0, 0, 0, 0)","none"]
            },
            {
                id: 'Rectangle7',
                type: 'rect',
                rect: ['458px', '339px','309px','45px','auto', 'auto'],
                fill: ["rgba(255,255,255,1.00)"],
                stroke: [0,"rgba(0, 0, 0, 0)","none"]
            },
            {
                id: 'Rectangle9',
                type: 'rect',
                rect: ['458px', '388px','292px','45px','auto', 'auto'],
                fill: ["rgba(255,255,255,1.00)"],
                stroke: [0,"rgba(0, 0, 0, 0)","none"]
            },
            {
                id: 'Rectangle2',
                type: 'rect',
                rect: ['338px', '497px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy',
                type: 'rect',
                rect: ['406px', '477px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy4',
                type: 'rect',
                rect: ['406px', '546px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy5',
                type: 'rect',
                rect: ['318px', '403px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy6',
                type: 'rect',
                rect: ['328px', '328px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy7',
                type: 'rect',
                rect: ['472px', '507px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy8',
                type: 'rect',
                rect: ['467px', '580px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy9',
                type: 'rect',
                rect: ['540px', '615px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy13',
                type: 'rect',
                rect: ['598px', '570px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy14',
                type: 'rect',
                rect: ['668px', '560px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy15',
                type: 'rect',
                rect: ['688px', '497px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy16',
                type: 'rect',
                rect: ['737px', '447px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy17',
                type: 'rect',
                rect: ['717px', '378px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy18',
                type: 'rect',
                rect: ['737px', '313px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy19',
                type: 'rect',
                rect: ['688px', '261px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy20',
                type: 'rect',
                rect: ['653px', '201px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy21',
                type: 'rect',
                rect: ['578px', '186px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy22',
                type: 'rect',
                rect: ['520px', '153px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy23',
                type: 'rect',
                rect: ['457px', '191px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy24',
                type: 'rect',
                rect: ['386px', '206px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy25',
                type: 'rect',
                rect: ['366px', '271px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy10',
                type: 'rect',
                rect: ['530px', '546px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy26',
                type: 'rect',
                rect: ['588px', '507px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy27',
                type: 'rect',
                rect: ['643px', '467px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy28',
                type: 'rect',
                rect: ['658px', '413px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy29',
                type: 'rect',
                rect: ['668px', '338px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy30',
                type: 'rect',
                rect: ['643px', '291px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy31',
                type: 'rect',
                rect: ['588px', '271px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy32',
                type: 'rect',
                rect: ['540px', '226px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy43',
                type: 'rect',
                rect: ['203px', '376px','20px','20px','auto', 'auto'],
                fill: ["rgba(0,62,249,1.00)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy33',
                type: 'rect',
                rect: ['502px', '271px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy34',
                type: 'rect',
                rect: ['437px', '251px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy35',
                type: 'rect',
                rect: ['437px', '313px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy36',
                type: 'rect',
                rect: ['386px', '348px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy11',
                type: 'rect',
                rect: ['457px', '423px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy37',
                type: 'rect',
                rect: ['452px', '368px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy38',
                type: 'rect',
                rect: ['492px', '328px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy39',
                type: 'rect',
                rect: ['568px', '328px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy40',
                type: 'rect',
                rect: ['604px', '378px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy41',
                type: 'rect',
                rect: ['588px', '447px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 0, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy42',
                type: 'rect',
                rect: ['482px', '457px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy12',
                type: 'rect',
                rect: ['530px', '477px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            },
            {
                id: 'Rectangle2Copy2',
                type: 'rect',
                rect: ['396px', '403px','20px','20px','auto', 'auto'],
                fill: ["rgba(98,137,255,0.99)"],
                stroke: [0,"rgb(0, 0, 0)","none"],
                filter: [0, 0, 1, 1, 0, 0, 0, 5, "rgba(0,0,0,0.00)", 0, 0, 0]
            }],
            symbolInstances: [

            ]
        },
    states: {
        "Base State": {
            "${_Rectangle2}": [
                ["style", "top", '472px'],
                ["color", "background-color", 'rgba(98,137,255,0.9922)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0.00)'],
                ["motion", "location", '363px 497px'],
                ["style", "height", '30px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '353px'],
                ["style", "width", '30px']
            ],
            "${_Rectangle2Copy40}": [
                ["style", "top", '388px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '614px 388px'],
                ["style", "left", '594px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy25}": [
                ["style", "top", '261px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["motion", "location", '376px 281px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '358px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy37}": [
                ["style", "top", '368px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["motion", "location", '462px 378px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '462px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy5}": [
                ["style", "top", '403px'],
                ["color", "background-color", 'rgba(98,137,255,1.00)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '328px 413px'],
                ["style", "height", '30px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '318px'],
                ["style", "width", '30px']
            ],
            "${_Rectangle2Copy38}": [
                ["style", "top", '328px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '502px 338px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '500px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy35}": [
                ["style", "top", '313px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '447px 323px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '432px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy16}": [
                ["style", "top", '457px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '747px 457px'],
                ["style", "left", '747px'],
                ["style", "width", '20px']
            ],
            "${_CB_Logo}": [
                ["style", "top", '357px'],
                ["style", "left", '463px']
            ],
            "${_Rectangle2Copy41}": [
                ["style", "top", '443px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '598px 457px'],
                ["style", "left", '578px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy42}": [
                ["style", "top", '457px'],
                ["color", "background-color", 'rgba(98,137,255,1.00)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '492px 467px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '490px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy33}": [
                ["style", "top", '271px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '512px 281px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '500px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy34}": [
                ["style", "top", '261px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["motion", "location", '447px 261px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '437px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy6}": [
                ["style", "top", '329px'],
                ["color", "background-color", 'rgba(98,137,255,0.98)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '328px 339px'],
                ["style", "height", '30px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '318px'],
                ["style", "width", '30px']
            ],
            "${_Rectangle2Copy12}": [
                ["style", "top", '477px'],
                ["color", "background-color", 'rgba(98,137,255,1.00)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '540px 487px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '530px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy13}": [
                ["style", "top", '580px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '608px 580px'],
                ["style", "left", '604px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy8}": [
                ["style", "top", '590px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '482px 590px'],
                ["style", "left", '467px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy4}": [
                ["style", "top", '546px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '30px'],
                ["motion", "location", '416px 556px'],
                ["style", "left", '406px'],
                ["style", "width", '30px']
            ],
            "${_Rectangle7}": [
                ["motion", "location", '612.5px 361.5px'],
                ["style", "top", '339px'],
                ["style", "left", '458px'],
                ["style", "height", '45px']
            ],
            "${_Rectangle2Copy15}": [
                ["style", "top", '497px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '698px 507px'],
                ["style", "left", '688px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy36}": [
                ["style", "top", '348px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["motion", "location", '396px 358px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '396px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy24}": [
                ["style", "top", '206px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '396px 216px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '396px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy31}": [
                ["style", "top", '271px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '598px 281px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '588px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy32}": [
                ["style", "top", '226px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["motion", "location", '550px 236px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '520px'],
                ["style", "width", '20px']
            ],
            "${_Stage}": [
                ["color", "background-color", 'rgba(255,255,255,1.00)'],
                ["style", "width", '1080px'],
                ["style", "height", '725px'],
                ["style", "position", 'none'],
                ["style", "margin", '0px auto'],
                ["style", "text-align", 'center'],
                ["style", "alignment-adjust", 'center']
            ],
            "${_Rectangle2Copy39}": [
                ["style", "top", '328px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["motion", "location", '578px 338px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '568px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle9}": [
                ["motion", "location", '604px 410.5px'],
                ["style", "width", '292px']
            ],
            "${_Rectangle2Copy2}": [
                ["style", "top", '413px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,0.9961)'],
                ["motion", "location", '391px 423px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '381px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy19}": [
                ["style", "top", '251px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '698px 271px'],
                ["style", "left", '678px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy28}": [
                ["style", "top", '413px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["motion", "location", '668px 423px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '663px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy43}": [
                ["style", "top", '376px'],
                ["color", "background-color", 'rgba(255,255,255,1.00)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '213px 386px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '5px'],
                ["style", "left", '211px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy10}": [
                ["style", "top", '546px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '540px 556px'],
                ["style", "left", '530px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy29}": [
                ["style", "top", '348px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '678px 348px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '653px'],
                ["style", "width", '20px']
            ],
            "${_senal}": [
                ["subproperty", "filter.drop-shadow.color", 'rgba(13,0,213,0.00)'],
                ["subproperty", "filter.contrast", '1.44'],
                ["style", "left", '315px'],
                ["subproperty", "filter.saturate", '6.3333333333333'],
                ["style", "top", '338px'],
                ["style", "width", '148px'],
                ["style", "height", '94px'],
                ["subproperty", "filter.blur", '0px'],
                ["subproperty", "filter.grayscale", '0'],
                ["subproperty", "filter.sepia", '0']
            ],
            "${_Rectangle2Copy14}": [
                ["style", "top", '564px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '678px 570px'],
                ["style", "left", '663px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy21}": [
                ["style", "top", '181px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '588px 196px'],
                ["style", "left", '578px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy22}": [
                ["style", "top", '155px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '530px 163px'],
                ["style", "left", '510px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy23}": [
                ["style", "top", '186px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '467px 201px'],
                ["style", "left", '457px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy30}": [
                ["style", "top", '287px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["motion", "location", '653px 301px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '643px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy}": [
                ["style", "top", '462px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,0.9961)'],
                ["motion", "location", '416px 487px'],
                ["style", "height", '30px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '416px'],
                ["style", "width", '30px']
            ],
            "${_Rectangle6}": [
                ["style", "top", '384px'],
                ["motion", "location", '603.5px 384.5px'],
                ["style", "height", '4px'],
                ["style", "left", '444px'],
                ["style", "width", '309px']
            ],
            "${_Rectangle2Copy26}": [
                ["style", "top", '517px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '598px 517px'],
                ["style", "left", '609px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy20}": [
                ["style", "top", '186px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '663px 211px'],
                ["style", "left", '643px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy17}": [
                ["style", "top", '383px'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["style", "height", '20px'],
                ["motion", "location", '727px 388px'],
                ["style", "left", '727px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy27}": [
                ["style", "top", '467px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '653px 477px'],
                ["style", "left", '643px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy7}": [
                ["style", "top", '513px'],
                ["color", "background-color", 'rgba(98,137,255,1.00)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '477px 517px'],
                ["style", "left", '467px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy11}": [
                ["style", "top", '433px'],
                ["color", "background-color", 'rgba(98,137,255,1.00)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '462px 433px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '472px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy18}": [
                ["style", "top", '313px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["motion", "location", '747px 323px'],
                ["style", "height", '20px'],
                ["subproperty", "filter.blur", '0px'],
                ["style", "left", '737px'],
                ["style", "width", '20px']
            ],
            "${_Rectangle2Copy9}": [
                ["style", "top", '615px'],
                ["color", "background-color", 'rgba(98,137,255,1)'],
                ["subproperty", "filter.drop-shadow.color", 'rgba(0,0,0,0)'],
                ["style", "height", '20px'],
                ["motion", "location", '550px 625px'],
                ["style", "left", '540px'],
                ["style", "width", '20px']
            ]
        }
    },
    timelines: {
        "Default Timeline": {
            fromState: "Base State",
            toState: "",
            duration: 2250,
            autoPlay: true,
            timeline: [
                { id: "eid398", tween: [ "style", "${_Rectangle2Copy}", "height", '20px', { fromValue: '30px'}], position: 45, duration: 750, easing: "easeOutQuad" },
                { id: "eid252", tween: [ "motion", "${_Rectangle2Copy29}", [[678, 348, 0, 0],[535, 395, 0, 0]]], position: 340, duration: 750, easing: "easeOutQuad" },
                { id: "eid31", tween: [ "motion", "${_Rectangle2Copy10}", [[540, 556, 0, 0],[540, 388, 0, 0]]], position: 574, duration: 766, easing: "easeOutQuad" },
                { id: "eid528", tween: [ "color", "${_Rectangle2Copy43}", "background-color", 'rgba(255,255,255,1.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(255,255,255,1.00)'}], position: 0, duration: 0, easing: "easeOutQuad" },
                { id: "eid235", tween: [ "motion", "${_Rectangle2Copy37}", [[462, 378, 0, 0],[536, 393, 0, 0]]], position: 135, duration: 500, easing: "easeOutQuad" },
                { id: "eid276", tween: [ "color", "${_Rectangle2Copy14}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 250, duration: 1000, easing: "easeOutQuad" },
                { id: "eid265", tween: [ "motion", "${_Rectangle2Copy22}", [[530, 163, 0, 0],[530, 395, 0, 0]]], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid273", tween: [ "motion", "${_Rectangle2Copy13}", [[608, 580, 0, 0],[535, 393, 0, 0]]], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid47", tween: [ "color", "${_Rectangle2Copy}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,0.9961)'}], position: 45, duration: 750, easing: "easeOutQuad" },
                { id: "eid410", tween: [ "style", "${_Rectangle2Copy6}", "height", '20px', { fromValue: '30px'}], position: 0, duration: 1250, easing: "easeOutQuad" },
                { id: "eid232", tween: [ "motion", "${_Rectangle2Copy39}", [[578, 338, 0, 0],[535, 395, 0, 0]]], position: 95, duration: 207, easing: "easeOutQuad" },
                { id: "eid380", tween: [ "motion", "${_Rectangle2Copy39}", [[578, 338, 0, 0],[535, 395, 0, 0]]], position: 302, duration: 208, easing: "easeOutQuad" },
                { id: "eid382", tween: [ "motion", "${_Rectangle2Copy39}", [[578, 338, 0, 0],[535, 395, 0, 0]]], position: 510, duration: 208, easing: "easeOutQuad" },
                { id: "eid384", tween: [ "motion", "${_Rectangle2Copy39}", [[578, 338, 0, 0],[535, 395, 0, 0]]], position: 717, duration: 208, easing: "easeOutQuad" },
                { id: "eid386", tween: [ "motion", "${_Rectangle2Copy39}", [[578, 338, 0, 0],[535, 395, 0, 0]]], position: 925, duration: 208, easing: "easeOutQuad" },
                { id: "eid388", tween: [ "motion", "${_Rectangle2Copy39}", [[578, 338, 0, 0],[535, 395, 0, 0]]], position: 1132, duration: 208, easing: "easeOutQuad" },
                { id: "eid513", tween: [ "motion", "${_Rectangle7}", [[612.5, 361.5, 0, 0],[612.5, 334.5, 0, 0]]], position: 135, duration: 955, easing: "easeOutQuad" },
                { id: "eid40", tween: [ "motion", "${_Rectangle2Copy7}", [[477, 517, 0, 0],[535, 378, 0, 0]]], position: 135, duration: 750, easing: "easeOutQuad" },
                { id: "eid281", tween: [ "motion", "${_Rectangle2Copy17}", [[727, 388, 0, 0],[538, 393, 0, 0]]], position: 250, duration: 1000, easing: "easeOutQuad" },
                { id: "eid278", tween: [ "color", "${_Rectangle2Copy15}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 135, duration: 1000, easing: "easeOutQuad" },
                { id: "eid239", tween: [ "color", "${_Rectangle2Copy35}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 302, duration: 750, easing: "easeOutQuad" },
                { id: "eid242", tween: [ "motion", "${_Rectangle2Copy33}", [[512, 281, 0, 0],[536, 393, 0, 0]]], position: 0, duration: 750, easing: "easeOutQuad" },
                { id: "eid406", tween: [ "style", "${_Rectangle2Copy5}", "height", '20px', { fromValue: '30px'}], position: 95, duration: 1000, easing: "easeOutQuad" },
                { id: "eid272", tween: [ "color", "${_Rectangle2Copy19}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid34", tween: [ "motion", "${_Rectangle2Copy9}", [[550, 625, 0, 0],[540, 388, 0, 0]]], position: 340, duration: 1000, easing: "easeOutQuad" },
                { id: "eid279", tween: [ "motion", "${_Rectangle2Copy16}", [[747, 457, 0, 0],[531, 388, 0, 0]]], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid275", tween: [ "motion", "${_Rectangle2Copy14}", [[678, 570, 0, 0],[535, 393, 0, 0]]], position: 250, duration: 1000, easing: "easeOutQuad" },
                { id: "eid264", tween: [ "color", "${_Rectangle2Copy23}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 340, duration: 1000, easing: "easeOutQuad" },
                { id: "eid42", tween: [ "color", "${_Rectangle2Copy7}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 135, duration: 750, easing: "easeOutQuad" },
                { id: "eid255", tween: [ "motion", "${_Rectangle2Copy27}", [[653, 477, 0, 0],[536, 393, 0, 0]]], position: 0, duration: 750, easing: "easeOutQuad" },
                { id: "eid268", tween: [ "color", "${_Rectangle2Copy21}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 135, duration: 1000, easing: "easeOutQuad" },
                { id: "eid270", tween: [ "color", "${_Rectangle2Copy20}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 340, duration: 1000, easing: "easeOutQuad" },
                { id: "eid525", tween: [ "style", "${_Rectangle2Copy43}", "width", '50px', { fromValue: '20px'}], position: 0, duration: 1132, easing: "easeOutQuad" },
                { id: "eid417", tween: [ "motion", "${_Rectangle2Copy43}", [[213, 386, 0, 0],[317, 386, 0, 0]]], position: 250, duration: 260, easing: "easeOutQuad" },
                { id: "eid425", tween: [ "motion", "${_Rectangle2Copy43}", [[317, 386, 0, 0],[356.5, 386, 0, 0]]], position: 510, duration: 134, easing: "easeOutQuad" },
                { id: "eid427", tween: [ "motion", "${_Rectangle2Copy43}", [[356.5, 386, 0, 0],[372, 344, 0, 0]]], position: 644, duration: 106, easing: "easeOutQuad" },
                { id: "eid429", tween: [ "motion", "${_Rectangle2Copy43}", [[372, 344, 0, 0],[389, 425, 0, 0]]], position: 750, duration: 175, easing: "easeOutQuad" },
                { id: "eid431", tween: [ "motion", "${_Rectangle2Copy43}", [[389, 425, 0, 0],[406, 386, 0, 0]]], position: 925, duration: 127, easing: "easeOutQuad" },
                { id: "eid516", tween: [ "motion", "${_Rectangle2Copy43}", [[406, 386, 0, 0],[794, 386, 0, 0]]], position: 1052, duration: 948, easing: "easeOutQuad" },
                { id: "eid259", tween: [ "motion", "${_Rectangle2Copy25}", [[376, 281, 0, 0],[538, 395, 0, 0]]], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid263", tween: [ "motion", "${_Rectangle2Copy23}", [[467, 201, 0, 0],[538, 393, 0, 0]]], position: 340, duration: 1000, easing: "easeOutQuad" },
                { id: "eid37", tween: [ "color", "${_Rectangle2Copy8}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid254", tween: [ "color", "${_Rectangle2Copy28}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 574, duration: 766, easing: "easeOutQuad" },
                { id: "eid23", tween: [ "motion", "${_Rectangle2Copy12}", [[540, 487, 0, 0],[535, 388, 0, 0]]], position: 180, duration: 232, easing: "easeOutSine" },
                { id: "eid336", tween: [ "motion", "${_Rectangle2Copy12}", [[540, 487, 0, 0],[535, 388, 0, 0]]], position: 412, duration: 232, easing: "easeOutSine" },
                { id: "eid338", tween: [ "motion", "${_Rectangle2Copy12}", [[540, 487, 0, 0],[535, 388, 0, 0]]], position: 644, duration: 232, easing: "easeOutSine" },
                { id: "eid349", tween: [ "motion", "${_Rectangle2Copy12}", [[540, 487, 0, 0],[535, 388, 0, 0]]], position: 876, duration: 232, easing: "easeOutSine" },
                { id: "eid351", tween: [ "motion", "${_Rectangle2Copy12}", [[540, 487, 0, 0],[535, 388, 0, 0]]], position: 1108, duration: 232, easing: "easeOutSine" },
                { id: "eid260", tween: [ "color", "${_Rectangle2Copy25}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid262", tween: [ "color", "${_Rectangle2Copy24}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 180, duration: 1000, easing: "easeOutQuad" },
                { id: "eid230", tween: [ "color", "${_Rectangle2Copy40}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 180, duration: 232, easing: "easeOutSine" },
                { id: "eid364", tween: [ "color", "${_Rectangle2Copy40}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 412, duration: 232, easing: "easeOutSine" },
                { id: "eid366", tween: [ "color", "${_Rectangle2Copy40}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 644, duration: 232, easing: "easeOutSine" },
                { id: "eid368", tween: [ "color", "${_Rectangle2Copy40}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 876, duration: 232, easing: "easeOutSine" },
                { id: "eid370", tween: [ "color", "${_Rectangle2Copy40}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 1108, duration: 232, easing: "easeOutSine" },
                { id: "eid403", tween: [ "style", "${_Rectangle2Copy4}", "width", '20px', { fromValue: '30px'}], position: 191, duration: 989, easing: "easeOutQuad" },
                { id: "eid51", tween: [ "color", "${_Rectangle2Copy5}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 95, duration: 1000, easing: "easeOutQuad" },
                { id: "eid394", tween: [ "style", "${_Rectangle2}", "height", '20px', { fromValue: '30px'}], position: 180, duration: 1000, easing: "easeOutQuad" },
                { id: "eid49", tween: [ "motion", "${_Rectangle2Copy5}", [[328, 413, 0, 0],[535, 388, 0, 0]]], position: 95, duration: 1000, easing: "easeOutQuad" },
                { id: "eid25", tween: [ "color", "${_Rectangle2Copy12}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 180, duration: 232, easing: "easeOutSine" },
                { id: "eid337", tween: [ "color", "${_Rectangle2Copy12}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 412, duration: 232, easing: "easeOutSine" },
                { id: "eid339", tween: [ "color", "${_Rectangle2Copy12}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 644, duration: 232, easing: "easeOutSine" },
                { id: "eid348", tween: [ "color", "${_Rectangle2Copy12}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 876, duration: 232, easing: "easeOutSine" },
                { id: "eid350", tween: [ "color", "${_Rectangle2Copy12}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 1108, duration: 232, easing: "easeOutSine" },
                { id: "eid261", tween: [ "motion", "${_Rectangle2Copy24}", [[396, 216, 0, 0],[538, 398, 0, 0]]], position: 180, duration: 1000, easing: "easeOutQuad" },
                { id: "eid27", tween: [ "motion", "${_Rectangle2Copy11}", [[462, 433, 0, 0],[545, 398, 0, 0]]], position: 250, duration: 500, easing: "easeOutQuad" },
                { id: "eid274", tween: [ "color", "${_Rectangle2Copy13}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid512", tween: [ "motion", "${_Rectangle9}", [[604, 410.5, 0, 0],[604, 448.5, 0, 0]]], position: 135, duration: 955, easing: "easeOutQuad" },
                { id: "eid258", tween: [ "color", "${_Rectangle2Copy26}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 250, duration: 750, easing: "easeOutQuad" },
                { id: "eid256", tween: [ "color", "${_Rectangle2Copy27}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 750, easing: "easeOutQuad" },
                { id: "eid411", tween: [ "style", "${_Rectangle2Copy6}", "width", '20px', { fromValue: '30px'}], position: 0, duration: 1250, easing: "easeOutQuad" },
                { id: "eid407", tween: [ "style", "${_Rectangle2Copy5}", "width", '20px', { fromValue: '30px'}], position: 95, duration: 1000, easing: "easeOutQuad" },
                { id: "eid243", tween: [ "color", "${_Rectangle2Copy33}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 750, easing: "easeOutQuad" },
                { id: "eid35", tween: [ "color", "${_Rectangle2Copy9}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 340, duration: 1000, easing: "easeOutQuad" },
                { id: "eid249", tween: [ "color", "${_Rectangle2Copy30}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 750, easing: "easeOutQuad" },
                { id: "eid44", tween: [ "motion", "${_Rectangle2Copy4}", [[416, 556, 0, 0],[540, 388, 0, 0]]], position: 180, duration: 1000, easing: "easeOutQuad" },
                { id: "eid402", tween: [ "style", "${_Rectangle2Copy4}", "height", '20px', { fromValue: '30px'}], position: 191, duration: 989, easing: "easeOutQuad" },
                { id: "eid240", tween: [ "motion", "${_Rectangle2Copy34}", [[447, 261, 0, 0],[538, 395, 0, 0]]], position: 574, duration: 766, easing: "easeOutQuad" },
                { id: "eid248", tween: [ "motion", "${_Rectangle2Copy31}", [[598, 281, 0, 0],[535, 393, 0, 0]]], position: 574, duration: 766, easing: "easeOutQuad" },
                { id: "eid247", tween: [ "color", "${_Rectangle2Copy31}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 574, duration: 766, easing: "easeOutQuad" },
                { id: "eid395", tween: [ "style", "${_Rectangle2}", "width", '20px', { fromValue: '30px'}], position: 180, duration: 1000, easing: "easeOutQuad" },
                { id: "eid253", tween: [ "motion", "${_Rectangle2Copy28}", [[668, 423, 0, 0],[535, 393, 0, 0]]], position: 574, duration: 766, easing: "easeOutQuad" },
                { id: "eid84", tween: [ "motion", "${_Rectangle2Copy}", [[416, 487, 0, 0],[426, 472, 0, 0, 0, 0],[535, 388, 0, 0]]], position: 45, duration: 750, easing: "easeOutQuad" },
                { id: "eid146", tween: [ "color", "${_Rectangle2Copy38}", "background-color", 'rgba(98,137,255,0.02)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 180, easing: "easeOutQuad" },
                { id: "eid244", tween: [ "color", "${_Rectangle2Copy32}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 302, duration: 750, easing: "easeOutQuad" },
                { id: "eid283", tween: [ "motion", "${_Rectangle2Copy18}", [[747, 323, 0, 0],[536, 395, 0, 0]]], position: 340, duration: 1000, easing: "easeOutQuad" },
                { id: "eid229", tween: [ "motion", "${_Rectangle2Copy41}", [[598, 457, 0, 0],[538, 393, 0, 0]]], position: 0, duration: 191, easing: "easeOutSine" },
                { id: "eid345", tween: [ "motion", "${_Rectangle2Copy41}", [[598, 457, 0, 0],[538, 393, 0, 0]]], position: 191, duration: 191, easing: "easeOutSine" },
                { id: "eid347", tween: [ "motion", "${_Rectangle2Copy41}", [[598, 457, 0, 0],[538, 393, 0, 0]]], position: 383, duration: 191, easing: "easeOutSine" },
                { id: "eid361", tween: [ "motion", "${_Rectangle2Copy41}", [[598, 457, 0, 0],[538, 393, 0, 0]]], position: 574, duration: 191, easing: "easeOutSine" },
                { id: "eid362", tween: [ "motion", "${_Rectangle2Copy41}", [[598, 457, 0, 0],[538, 393, 0, 0]]], position: 766, duration: 191, easing: "easeOutSine" },
                { id: "eid377", tween: [ "motion", "${_Rectangle2Copy41}", [[598, 457, 0, 0],[538, 393, 0, 0]]], position: 957, duration: 191, easing: "easeOutSine" },
                { id: "eid376", tween: [ "motion", "${_Rectangle2Copy41}", [[598, 457, 0, 0],[538, 393, 0, 0]]], position: 1149, duration: 191, easing: "easeOutSine" },
                { id: "eid145", tween: [ "motion", "${_Rectangle2Copy38}", [[502, 338, 0, 0],[536, 395, 0, 0]]], position: 0, duration: 180, easing: "easeOutQuad" },
                { id: "eid236", tween: [ "color", "${_Rectangle2Copy36}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 750, easing: "easeOutQuad" },
                { id: "eid226", tween: [ "motion", "${_Rectangle2Copy42}", [[492, 467, 0, 0],[535, 393, 0, 0]]], position: 95, duration: 207, easing: "easeOutSine" },
                { id: "eid340", tween: [ "motion", "${_Rectangle2Copy42}", [[492, 467, 0, 0],[535, 393, 0, 0]]], position: 302, duration: 207, easing: "easeOutSine" },
                { id: "eid352", tween: [ "motion", "${_Rectangle2Copy42}", [[492, 467, 0, 0],[535, 393, 0, 0]]], position: 510, duration: 207, easing: "easeOutSine" },
                { id: "eid353", tween: [ "motion", "${_Rectangle2Copy42}", [[492, 467, 0, 0],[535, 393, 0, 0]]], position: 717, duration: 207, easing: "easeOutSine" },
                { id: "eid357", tween: [ "motion", "${_Rectangle2Copy42}", [[492, 467, 0, 0],[535, 393, 0, 0]]], position: 925, duration: 207, easing: "easeOutSine" },
                { id: "eid373", tween: [ "motion", "${_Rectangle2Copy42}", [[492, 467, 0, 0],[535, 393, 0, 0]]], position: 1132, duration: 207, easing: "easeOutSine" },
                { id: "eid269", tween: [ "motion", "${_Rectangle2Copy20}", [[663, 211, 0, 0],[531, 393, 0, 0]]], position: 340, duration: 1000, easing: "easeOutQuad" },
                { id: "eid266", tween: [ "color", "${_Rectangle2Copy22}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid241", tween: [ "color", "${_Rectangle2Copy34}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 574, duration: 766, easing: "easeOutQuad" },
                { id: "eid282", tween: [ "color", "${_Rectangle2Copy17}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 250, duration: 1000, easing: "easeOutQuad" },
                { id: "eid526", tween: [ "style", "${_Rectangle2Copy43}", "height", '50px', { fromValue: '20px'}], position: 0, duration: 1132, easing: "easeOutQuad" },
                { id: "eid18", tween: [ "motion", "${_Rectangle2Copy6}", [[328, 339, 0, 0],[540, 388, 0, 0]]], position: 0, duration: 1250, easing: "easeOutQuad" },
                { id: "eid56", tween: [ "motion", "${_Rectangle2}", [[363, 497, 0, 0],[540, 393, 0, 0]]], position: 180, duration: 1000, easing: "easeOutQuad" },
                { id: "eid251", tween: [ "color", "${_Rectangle2Copy29}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 340, duration: 750, easing: "easeOutQuad" },
                { id: "eid250", tween: [ "motion", "${_Rectangle2Copy30}", [[653, 301, 0, 0],[536, 393, 0, 0]]], position: 0, duration: 750, easing: "easeOutQuad" },
                { id: "eid13", tween: [ "motion", "${_Rectangle2Copy2}", [[391, 423, 0, 0],[540, 393, 0, 0]]], position: 45, duration: 750, easing: "easeOutSine" },
                { id: "eid32", tween: [ "color", "${_Rectangle2Copy10}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 574, duration: 766, easing: "easeOutQuad" },
                { id: "eid238", tween: [ "motion", "${_Rectangle2Copy35}", [[447, 323, 0, 0],[538, 393, 0, 0]]], position: 302, duration: 750, easing: "easeOutQuad" },
                { id: "eid227", tween: [ "color", "${_Rectangle2Copy42}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 95, duration: 207, easing: "easeOutSine" },
                { id: "eid341", tween: [ "color", "${_Rectangle2Copy42}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 302, duration: 207, easing: "easeOutSine" },
                { id: "eid354", tween: [ "color", "${_Rectangle2Copy42}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 510, duration: 207, easing: "easeOutSine" },
                { id: "eid355", tween: [ "color", "${_Rectangle2Copy42}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 717, duration: 207, easing: "easeOutSine" },
                { id: "eid356", tween: [ "color", "${_Rectangle2Copy42}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 925, duration: 207, easing: "easeOutSine" },
                { id: "eid372", tween: [ "color", "${_Rectangle2Copy42}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 1132, duration: 207, easing: "easeOutSine" },
                { id: "eid257", tween: [ "motion", "${_Rectangle2Copy26}", [[598, 517, 0, 0],[535, 393, 0, 0]]], position: 250, duration: 750, easing: "easeOutQuad" },
                { id: "eid280", tween: [ "color", "${_Rectangle2Copy16}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid54", tween: [ "color", "${_Rectangle2}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,0.9922)'}], position: 180, duration: 1000, easing: "easeOutQuad" },
                { id: "eid231", tween: [ "motion", "${_Rectangle2Copy40}", [[614, 388, 0, 0],[535, 395, 0, 0]]], position: 180, duration: 232, easing: "easeOutSine" },
                { id: "eid365", tween: [ "motion", "${_Rectangle2Copy40}", [[614, 388, 0, 0],[535, 395, 0, 0]]], position: 412, duration: 232, easing: "easeOutSine" },
                { id: "eid367", tween: [ "motion", "${_Rectangle2Copy40}", [[614, 388, 0, 0],[535, 395, 0, 0]]], position: 644, duration: 232, easing: "easeOutSine" },
                { id: "eid369", tween: [ "motion", "${_Rectangle2Copy40}", [[614, 388, 0, 0],[535, 395, 0, 0]]], position: 876, duration: 232, easing: "easeOutSine" },
                { id: "eid371", tween: [ "motion", "${_Rectangle2Copy40}", [[614, 388, 0, 0],[535, 395, 0, 0]]], position: 1108, duration: 232, easing: "easeOutSine" },
                { id: "eid16", tween: [ "color", "${_Rectangle2Copy2}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,0.9961)'}], position: 45, duration: 750, easing: "easeOutSine" },
                { id: "eid267", tween: [ "motion", "${_Rectangle2Copy21}", [[588, 196, 0, 0],[538, 393, 0, 0]]], position: 135, duration: 1000, easing: "easeOutQuad" },
                { id: "eid246", tween: [ "motion", "${_Rectangle2Copy32}", [[550, 236, 0, 0],[535, 395, 0, 0]]], position: 302, duration: 750, easing: "easeOutQuad" },
                { id: "eid277", tween: [ "motion", "${_Rectangle2Copy15}", [[698, 507, 0, 0],[535, 393, 0, 0]]], position: 135, duration: 1000, easing: "easeOutQuad" },
                { id: "eid45", tween: [ "color", "${_Rectangle2Copy4}", "background-color", 'rgba(0,58,236,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 180, duration: 1000, easing: "easeOutQuad" },
                { id: "eid228", tween: [ "color", "${_Rectangle2Copy41}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 0, duration: 191, easing: "easeOutSine" },
                { id: "eid344", tween: [ "color", "${_Rectangle2Copy41}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 191, duration: 191, easing: "easeOutSine" },
                { id: "eid346", tween: [ "color", "${_Rectangle2Copy41}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 383, duration: 191, easing: "easeOutSine" },
                { id: "eid358", tween: [ "color", "${_Rectangle2Copy41}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 574, duration: 191, easing: "easeOutSine" },
                { id: "eid359", tween: [ "color", "${_Rectangle2Copy41}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 766, duration: 191, easing: "easeOutSine" },
                { id: "eid378", tween: [ "color", "${_Rectangle2Copy41}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 957, duration: 191, easing: "easeOutSine" },
                { id: "eid379", tween: [ "color", "${_Rectangle2Copy41}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 1149, duration: 191, easing: "easeOutSine" },
                { id: "eid399", tween: [ "style", "${_Rectangle2Copy}", "width", '20px', { fromValue: '30px'}], position: 45, duration: 750, easing: "easeOutQuad" },
                { id: "eid284", tween: [ "color", "${_Rectangle2Copy18}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 340, duration: 1000, easing: "easeOutQuad" },
                { id: "eid234", tween: [ "color", "${_Rectangle2Copy37}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 135, duration: 500, easing: "easeOutQuad" },
                { id: "eid20", tween: [ "color", "${_Rectangle2Copy6}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,0.98)'}], position: 0, duration: 1250, easing: "easeOutQuad" },
                { id: "eid271", tween: [ "motion", "${_Rectangle2Copy19}", [[698, 271, 0, 0],[536, 396, 0, 0]]], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid237", tween: [ "motion", "${_Rectangle2Copy36}", [[396, 358, 0, 0],[535, 393, 0, 0]]], position: 0, duration: 750, easing: "easeOutQuad" },
                { id: "eid233", tween: [ "color", "${_Rectangle2Copy39}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 95, duration: 207, easing: "easeOutQuad" },
                { id: "eid381", tween: [ "color", "${_Rectangle2Copy39}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 302, duration: 208, easing: "easeOutQuad" },
                { id: "eid383", tween: [ "color", "${_Rectangle2Copy39}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 510, duration: 208, easing: "easeOutQuad" },
                { id: "eid385", tween: [ "color", "${_Rectangle2Copy39}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 717, duration: 208, easing: "easeOutQuad" },
                { id: "eid387", tween: [ "color", "${_Rectangle2Copy39}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 925, duration: 208, easing: "easeOutQuad" },
                { id: "eid389", tween: [ "color", "${_Rectangle2Copy39}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1)'}], position: 1132, duration: 208, easing: "easeOutQuad" },
                { id: "eid38", tween: [ "motion", "${_Rectangle2Copy8}", [[482, 590, 0, 0],[535, 388, 0, 0]]], position: 0, duration: 1000, easing: "easeOutQuad" },
                { id: "eid29", tween: [ "color", "${_Rectangle2Copy11}", "background-color", 'rgba(98,137,255,0.00)', { animationColorSpace: 'RGB', valueTemplate: undefined, fromValue: 'rgba(98,137,255,1.00)'}], position: 250, duration: 500, easing: "easeOutQuad" }            ]
        }
    }
}
};


Edge.registerCompositionDefn(compId, symbols, fonts, resources, opts);

/**
 * Adobe Edge DOM Ready Event Handler
 */
$(window).ready(function() {
     Edge.launchComposition(compId);
});
})(jQuery, AdobeEdge, "EDGE-13891063");
