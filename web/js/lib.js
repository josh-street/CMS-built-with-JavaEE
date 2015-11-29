window.onload = initPage;

function initPage() { // The first function it calls enables the add 
eventHandler();     // Finally the last one calls the event handler.             
}

function eventHandler() {
	if (document.title.indexOf("Login") > -1){
		document.getElementById("registerBTN").addEventListener( "click", newUser );
		document.getElementById("bk2Login").addEventListener( "click", bk2Login );
	} else if(document.title.indexOf("Proposal") > -1) {
		tableSwap(); 
                //document.getElementById("filterText").addEventListener("keydown", filter);
	} else {
		document.getElementById("newSuggestionBTN").addEventListener( "click", newProposal );
		document.getElementById("cancelsugBTN").addEventListener("click", bk2main );
               // document.getElementsByName("filter").addEventListener("keyup", filter);
	}
};

newProposal = function() {
	var box = document.getElementById("suggestionBox");
	if (box.style.display === "none"){
		box.style.display = "block";
	} else {
		box.style.display = "none";
	}
};

bk2main = function() {
	var box = document.getElementById("suggestionBox");
	if (box.style.display === "block"){
		box.style.display = "none";
	} else {
		box.style.display = "none";
	}
};


newUser = function() {
	var regBox = document.getElementById("newuserBox");
	var logBox = document.getElementById("login");
	console.log(regBox.style.display);
	if (regBox.style.display === "none"){
		logBox.style.display = "none";
		regBox.style.display = "block";
	} else {
		regBox.style.display = "none";
		logBox.style.display = "block";
	}
};

bk2Login = function() {
	var regBox = document.getElementById("newuserBox");
	var logBox = document.getElementById("login");
	if (regBox.style.display === "block"){
		logBox.style.display = "block";
		regBox.style.display = "none";
	} else {
		regBox.style.display = "block";
		logBox.style.display = "none";
	}
};

function tableSwap(){
	var myTable = document.getElementById('tempTable');
	var newTable = document.createElement('table');
        var divArea = document.getElementById('proposal');
        newTable.id = "propTable";
	var maxColumns = 0;
// Find the max number of columns
    for(var r = 0; r < myTable.rows.length; r++) {
	if(myTable.rows[r].cells.length > maxColumns) {
		maxColumns = myTable.rows[r].cells.length;
	}
}


    for(var c = 0; c < maxColumns; c++) {
	newTable.insertRow(c);
	for(var r = 0; r < myTable.rows.length; r++) {
		if(myTable.rows[r].length <= c) {
			newTable.rows[c].insertCell(r);
			newTable.rows[c].cells[r] = '-';
		}
		else {
			newTable.rows[c].insertCell(r);
			newTable.rows[c].cells[r].innerHTML = myTable.rows[r].cells[c].innerHTML;
		}
	}
}
divArea.appendChild(newTable);
myTable.style.display = 'none';
} 

//function filter() {
//        var phrase = document.getElementById("filterText").value;
//        //console.log('fire');
//	var words = phrase.toLowerCase().split(" ");
//	var table1 = document.getElementsByClassName('filterable');
//        console.log(table1[0]);
//        var table = table1[0];
//	var ele;
//	for (var r = 1; r < table.rows.length; r++){
//		ele = table.rows[r].innerHTML.replace(/<[^>]+>/g,"");
//	        var displayStyle = 'none';
//	        for (var i = 0; i < words.length; i++) {
//		    if (ele.toLowerCase().indexOf(words[i])>=0)
//			displayStyle = '';
//		    else {
//			displayStyle = 'none';
//			break;
//		    }
//	        }
//		table.rows[r].style.display = displayStyle;
//	}
//}

function filter (){
        var phrase = document.getElementById("filterText").value;
	var suche = phrase.toLowerCase();
	var table1 = document.getElementsByClassName('filterable');
        console.log("fire");
        var table = table1[0];
	var ele;
	for (var r = 1; r < table.rows.length; r++){
		ele = table.rows[r].cells[1].innerHTML.replace(/<[^>]+>/g,"");
		if (ele.toLowerCase().indexOf(suche)>=0 )
			table.rows[r].style.display = '';
		else table.rows[r].style.display = 'none';
	}
}