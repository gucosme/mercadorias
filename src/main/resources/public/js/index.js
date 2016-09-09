/**
 * Created by gusta on 08/09/2016.
 */

$('#submit').on('click', function () {
    var formData = $('form').serializeArray();
    var mercadoria = mapObj(formData);

    $.post({
        type: 'POST',
        url: '/mercadoria',
        data: mercadoria,
        success: function () {
            window.location.replace('/operacoes.html');
        },
        dataType: 'json'
    });
});

var mapObj = function (data) {
    var obj = {};
    data.forEach(function (el) {
        obj[el.name] = el.value;
    });
    return obj;
}