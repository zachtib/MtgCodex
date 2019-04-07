package com.zachtib.mtgcodex.scryfall

//{
//    "object": "list",
//    "total_cards": 441,
//    "has_more": true,
//    "next_page": "https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&order=cmc&page=2&q=c%3Ared+pow%3D3&unique=cards",
//    "data": [ ...
data class ScryfallResponse<T>(
    val data: T
)