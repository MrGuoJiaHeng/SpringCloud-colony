$(document).ready(function () {
    prodectinit();
})

function prodectinit() {
    axios.get('/QueryShopFroRedis', {
        params: {}
    }).then(function (response) {
        prodectvue.products = response.data;
    }).catch(function (error) {
        console.log(error)
    })
}


var prodectvue = new Vue({
    el: '#prodect',
    data: {
        products: ''
    }, methods: {
        prodectdel: function (pid) {
            alert(pid)
            axios.get('/DelShopFroRedis', {
                params: {
                    pid: pid
                }
            }).then(function (value) {
                if (value.data == "SUCCESS") {
                    alert("删除成功")
                }
            }).then(function (error) {
                console.log(error)
            })


        }
    }
})