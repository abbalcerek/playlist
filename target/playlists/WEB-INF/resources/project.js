/**
 * Created by Adam on 22/08/2015.
 */

(function() {
    var app = angular.module('project', []);

    app.controller("ProjectController", function() {
        this.message = "hello world";
    });

    app.controller("ListSongController", function($http, $sce) {
        ctrl = this;
        ctrl.songs = [];

        //function getJsonFromUrl(urlString) {
        //    var query = urlString;
        //    var result = {};
        //    query.split("&").forEach(function(part) {
        //        var item = part.split("=");
        //        result[item[0]] = decodeURIComponent(item[1]);
        //    });
        //    return result;
        //}

        this.fakeAddress =
            $sce.trustAsResourceUrl("https://www.youtube.com/embed/Q6SLRda21os");
        this.getUrl = function(song) {
            if (song.urls.length === 0) return "fuck";
            return "";
            console.log(song.urls[0].url);
            return "https://www.youtube.com/embed/" + song.urls[0].url[1];
        };
        $http({
            method : 'GET',
            url : "http://localhost:8080/service/songs"
        }).success(function(data) {
            ctrl.songs = data;
        })
    });

    app.controller("FormController", function($http) {
        var ctrl =  this;
        this.song = {};
        this.addSong = function(songCtrl) {
            $http({
                method: 'GET',
                url: "http://localhost:8080/service/addSong",
                params: ctrl.song
            }).success(function(data) {
                alert(data[0]);
                songCtrl.songs = data;
                ctrl.song = {};
            });
        };
    });

})();

