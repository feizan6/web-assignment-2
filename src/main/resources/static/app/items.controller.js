/**
 * Created by Fayzan on 13/04/2017.
 */


// This is code based on an earlier implementation.

// (function () {
//     'use strict';
//
//     angular
//         .module('app')
//         .controller('ItemsController', ItemsController);
//
//     ItemsController.$inject = ['$http'];
//
//     function ItemsController($http) {
//         var vm = this;
//
//         vm.items = [];
//         vm.getAll = getAll;
//         vm.getCheapest = getCheapest;
//         vm.getLike = getLike;
//         vm.deleteItem = deleteItem;
//
//         init();
//
//         function init(){
//             getAll();
//         }
//
//         function getAll(){
//             var url = "/items/all";
//             var itemsPromise = $http.get(url);
//             itemsPromise.then(function(response){
//                 vm.items = response.data;
//             });
//         }
//
//         function getCheapest(){
//             var url = "/items/cheapest/" + 3.00;
//             var itemsPromise = $http.get(url);
//             itemsPromise.then(function(response){
//                 vm.items = response.data;
//             });
//         }
//
//         function getLike() {
//             var url = "items/searchByName" + apple;
//             var itemsPromise = $http.get(url);
//             itemsPromise.then(function (response) {
//                 vm.items = response.data;
//
//             })
//
//         }
//
//         function deleteItem(id){
//             var url = "/items/delete/" + id;
//             $http.post(url).then(function(response){
//                 vm.items = response.data;
//             });
//         }
//     }
// })();
