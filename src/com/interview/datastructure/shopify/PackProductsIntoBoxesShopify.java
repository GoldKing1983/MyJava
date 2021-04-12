package com.interview.datastructure.shopify;

/*

There are 3 products exists. BlueToothSpeaker, Playstation , Camera
2 types of boxes exists. Large and Medium

With below constraints.
1) BlueToothSpeaker is really big. It can fit into only Large box and it cannot fit into Medium Box.
2) PlayStation is big. A large box can take 2 PlayStations. But it cannot fit into Medium Box.
3) Camera is mediumSize. Medium box can take 2 Camera or Large Box can take 2 Camera.
4) You cannot fill 2 different products in a same box. 

Given a list products, return results like below.

Ex: Input : Camera, Camera, Camera: 
    Output: [L:Camera, Camera][M:Camera]

Ex: Input : BlueToothSpeaker, PlayStation, PlayStation, Camera: 
    Output: [L:BlueToothSpeaker][L:PlayStation, PlayStation][M:Camera]

Ex: Input : Camera, BlueToothSpeaker, PlayStation: 
Output: [L:BlueToothSpeaker][M:Camera][L:PlayStation]

Solution Approach: Eagerly Pack
1) Count no of BlueToothSpeaker, PlayStation, Camera
2) Eagerly fill 1 largebox with BlueToothSpeaker first.
3) Then Eagerly fill 1 largebox with 2 PlayStation. If the PlayStation is odd, add a largeBox.
4) Then Eagerly fill 1 largebox with 2 Camera. If the CameraCount is odd, add a mediumBox.


 */
public class PackProductsIntoBoxesShopify {

}
