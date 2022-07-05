#include<bits/stdc++.h>
using namespace std;

const int N = 1e3+4;
vector<int> graph[N];

int visited[N],level[N];

void bfs(int source){
	queue<int> q;
	q.push(source);
	visited[source]=1;

	while(!q.empty()){
		int cur_v = q.front();
		q.pop();
		cout<<cur_v<<" ";
		for(auto child  : graph[cur_v]){
		if(!visited[child]){
			q.push(child);
			visited[child]=1;
			level[child]=level[cur_v]+1;
		}
	}
	}
	

}




int main(){
 	
	int n;
	cin>>n;
	int n1=n;
	n1-=1;
	while(n1--){

		int v1,v2;
		cin>>v1>>v2;
		graph[v1].push_back(v2);
		graph[v2].push_back(v1);
	}
	bfs(1);

	for(auto i=1;i<n;++i){
		cout<<i<<" : "<<level[i]<<endl;
	}

	
	return 0;
} 
