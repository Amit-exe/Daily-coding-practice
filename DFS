#include<bits/stdc++.h>

using namespace std;

const int N = 1e5+10;
vector<int> g[N];
bool visited[N];

void dfs(int vertex){
	cout<<vertex<<endl;
	//task after entering vertex
	if(visited[vertex]) return ;  			// 1
	visited[vertex] = true;
	for(auto child : g[vertex]){
		cout<<"par"<<vertex<<" child "<<child<<endl;
	//task before entering child node 
		if(visited[child]) continue;		//2
		dfs(child);
	// task after exiting child node        // we can use either 1 or 2 whichever is convinient 
	}
	//task before exiting child
}
int main(){
	int n,m;
	cin>>n>>m;
	for(int i=0;i<m;++i){
		int v1,v2;
		cin>>v1>>v2;
		g[v1].push_back(v2);
		g[v2].push_back(v1);

	}
	dfs(1);
	return 0;
}
