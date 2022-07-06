#include<bits/stdc++.h>
using namespace std;

const int N = 1e5+4;
const int INF=1e9+10;

int visited[8][8],level[8][8];


int getX(string source){
	return source[0]-'a';
}
int getY(string source){
	return source[1]-'1';
}

vector<pair<int,int>> movements = {
	{-1,2}, {1,2},
	{-1,-2},{1,-2},
	{2,-1}, {2,1},
	{-2,-1},{-2,1}
};

bool isValid(int x, int y){
	return x>=0 && y>=0 && x<8 && y<8;
}

int bfs(string source, string dest){

	int sourceX = getX(source);
	int sourceY = getY(source);
	int destX = getX(dest);
	int destY = getY(dest);

	queue<pair<int,int>> q;
	q.push({sourceX,sourceY});
	visited[sourceX][sourceY]=1;
	level[sourceX][sourceY]=0;

	while(!q.empty()){
		pair<int,int> v = q.front();
		int x=v.first, y=v.second;
		q.pop();
		for(auto mov  : movements){

			int childX = mov.first+x;
			int childY = mov.second+y;
			if(!isValid(childX,childY)) continue;

			if(!visited[childX][childY]){
				q.push({childX,childY});
				visited[childX][childY]=1;
				level[childX][childY]=level[x][y]+1;
			}
		}
		if(level[destX][destY]!=INF) break;
	}
	
	return level[destX][destY];

}


void reset(){
	for(int i=0;i<8;++i){
		for(int j=0;j<8;j++){
			level[i][j]=INF;
			visited[i][j]=0;
		}
	}
}

int main(){
 	
	int n;
	cin>>n;
	while(n--){
		reset();
		string s1,s2;
		cin>>s1>>s2;
		cout<<bfs(s1,s2)<<endl;
	}

	
	return 0;
} 
