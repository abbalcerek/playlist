/**
 * Created by Adam on 22/08/2015.
 */

(function() {
    var app = angular.module('project', []);

    app.constant('conf', {
        address : 'localhost',
        port : 8081,
        protocol : 'http://'
    });


    app.controller("ProjectController", function() {
        this.message = "hello world";
    });

    app.controller("ListSongController", function($http, $sce, conf) {
        ctrl = this;
        ctrl.songs = [];


        this.fakeAddress =
            $sce.trustAsResourceUrl("https://www.youtube.com/embed/Q6SLRda21os");
        this.getUrl = function(song) {
            if (song.urls.length === 0) return "fuck";
            var id = song.urls[0].url.split('=')[1];
            return $sce.trustAsResourceUrl("https://www.youtube.com/embed/" + id + "?rel=0&autoplay=1");
        };
        $http({
            method : 'GET',
            url : conf.protocol + conf.address + ':' + conf.port + "/service/songs"
        }).success(function(data) {
            ctrl.songs = data;
        })
    });

    app.controller("FormController", function($http, conf) {
        var ctrl =  this;
        this.song = {};
        this.addSong = function(songCtrl) {
            $http({
                method: 'GET',
                url: conf.protocol + conf.address + ':' + conf.port + "/service/addSong",
                params: ctrl.song
            }).success(function(data) {
                songCtrl.songs = data;
                ctrl.song = {};
            });
        };
    });

})();

