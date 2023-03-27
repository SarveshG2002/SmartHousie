var Gname;
var Gpromo;
var Gphone;
var Gemail;
var tickets;
var selected_ticket;
var start_time;
var clogo;
var logos;
var updated_list=[]
var current_num;
var all_arr

var user_selected_numbers=[]
var first_line=[]
var second_line=[]
var third_line=[]
var isfld=""
var issld=""
var istld=""
var isefd=""
var page;
const d = new Date()
const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Dec"];
let x;
function get_clogo(){
	return clogo;
}
function get_updated_list(){
	return updated_list;
}
function get_logos(){
	return logos;
}
function get_name(){
	console.log("name")
    return Gname;
}
function get_promo(){
    return Gpromo;
}
function get_phone(){
    return Gphone;
}
function get_mail(){
    return Gemail;
}
function get_tickets(){
    return tickets;
}
function get_sel(){
	return [selected_ticket,start_time]
}
function get_start(){
    return start_time
}
function set_name(name){
    Gname=name;
}
function set_promo(promo){
    Gpromo=promo;
}
function set_phone(phone){
    Gphone=phone;
}
function set_mail(mail){
    Gemail=mail;
}
function set_tickets(mail){
    tickets=mail;
}
function set_sel(arr){
    selected_ticket=arr;
}
function set_start(data){
    start_time=data;
}
function set_clogo(data){
	clogo=data
}
function set_logos(data){
	logos=data
}
function set_updated_list(data){
	updated_list.push(data);
}


function load_page(){
    $.ajax({
        url: "load_page?",
        data: { "promo": Gpromo },
        type: "POST",
        success: async function (data, textStatus, jqXHR) {
          data=JSON.parse(data)
          page = data
          console.log(data)
          if(data[1]=="selected"){
            $("#main_container").load("tempo.html")
          }
          else if(data[1]=="default"){
            $("#main_container").load("smartHousie63.html")
          }
          else if(data[1]=="custom"){
            $("#main_container").load("tempo.html")
          }
          // $("#main_container").load(page + ".html");
        },
        error: function (jqXHR, textStatus, errorThrown) {
          console.log("not bad")
        }
      })
}