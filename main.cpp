//
//  main.cpp
//  Forest_p1
//
//  Created by Olyad Kitila on 12/11/20.
//  Copyright © 2020 Olyad Kitila. All rights reserved.
//

#include <iostream>
#include <fstream>

const int width = 31;
const int height = 323;

void printArray(char arr[][width]);

int main() {
    std::string line;
//    int height = 0, width = 0;
    
    std::ifstream forestMap;
    forestMap.open("/Users/olyadkitila/Advent Proj/Forest.txt");
//    if (forestMap.is_open()) {
//        while (getline(forestMap, line)) {
//            width = line.size() / sizeof(line[0]);
//            height++;
//        }
//
//    }

    char map[height][width];

    if (forestMap.is_open()) {
        int heightIndex = 0;
        while (getline(forestMap, line)) {
            for (int i = 0; i < width; i++) {
                map[heightIndex][i] = line[i];
            }
            heightIndex++;
        }
    }
    
    int treeCounter = 0;
    int x = 0;
    int y2 = 0;
    
    for (int y = 0; y2 < height; ++y) {
        //x = 7*y;
        
        if (x > 30) {
            x %= 31;
        }
        
        std::cout << "x: " << x << " and y2: " << y2 << std::endl;
        
        if (map[y2][x] == '#') {
            map[y2][x] = 'X';
            ++treeCounter;
        }
        
        ++x;
        y2 += 2;
    }
    
    printArray(map);
    
    //90 * 244 * 97 * 92 * 48;
    std::cout << treeCounter << std::endl << "9406609920" << std::endl;
    forestMap.close();
    
    
}


void printArray(char arr[][width]) {
    
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            std::cout << arr[i][j];
        }
        std::cout << std::endl;
    }
    
}

// 90 * 244 * 97 * 92 * 48
