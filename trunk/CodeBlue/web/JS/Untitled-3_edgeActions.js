/***********************
* Adobe Edge Animate Composition Actions
*
* Edit this file with caution, being careful to preserve 
* function signatures and comments starting with 'Edge' to maintain the 
* ability to interact with these actions from within Adobe Edge Animate
*
***********************/
(function($, Edge, compId){
var Composition = Edge.Composition, Symbol = Edge.Symbol; // aliases for commonly used Edge classes

   //Edge symbol: 'stage'
   (function(symbolName) {
      
      
      Symbol.bindTriggerAction(compId, symbolName, "Default Timeline", 2250, function(sym, e) {
         // insert code here
         sym.play(0);
         // Set the value of a Symbol variable
         
         var loopCount = sym.getVariable("loopCount");
         
         if(loopCount == 0){
         	// Gets an element. For example, 
         	// var element = sym.$("Text2");
         	// element.hide();
         	var element9 = sym.$("Rectangle9");
         	var element7 = sym.$("Rectangle7");
         	element9.hide();
         	element7.hide();
         	// Set the value of a Symbol variable
         
         
         }
         // Play the timeline at a label or specific time. For example:
         // sym.play(500); or sym.play("myLabel");
         //sym.play(800);
         
         
         

      });
      //Edge binding end

      

      Symbol.bindSymbolAction(compId, symbolName, "creationComplete", function(sym, e) {
         // insert code to be run when the symbol is created here
         sym.setVariable("loopCount",0);

      });
      //Edge binding end

   })("stage");
   //Edge symbol end:'stage'

})(jQuery, AdobeEdge, "EDGE-13891063");