/**
 * Created by Fayzan on 13/04/2017.
 */

(function () {
    'use strict';

    angular
        .module('app')
        .controller('ItemsController', ItemsController);

    ItemsController.$inject = ['$http'];

    function ItemsController($http) {
        var vm = this;

        vm.items = [];
        vm.getAll = getAll;
        vm.getAffordable = getCheapest;
        vm.deleteItem = deleteItem;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/items/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.items = response.data;
            });
        }

        function getCheapest(){
            var url = "/items/cheapest/" + 100;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.items = response.data;
            });
        }

        function deleteItem(id){
            var url = "/items/delete/" + id;
            $http.post(url).then(function(response){
                vm.items = response.data;
            });
        }
    }
})();
