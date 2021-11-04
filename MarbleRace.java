class Ball {
  float x;
  float y;
  float vx;
  float vy;
  
  Ball(int xx, int yy, int sx, int sy){
    x = xx;
    y = yy;
    vx = sx;
    vy = sy;
  }
}

class Cell {
  float x;
  float y;
};

int ballSize = 25;
int cellSize = 50;

color colors[] = {color(255, 0, 0), color(0, 255, 0)};
Ball balls[] = {new Ball(100, 100, 1, 1), new Ball(400, 400, -1, -1)};
Cell cells[];

void setup(){
  size(500, 500);  
  
  int totalCells = (width * height) / (cellSize * cellSize);
  print(totalCells);
  cells = new Cell[totalCells];
  for(int i = 0; i < totalCells; i++){
    cells[i] = new Cell();
    cells[i].x = (i % (500 / cellSize)) * cellSize;
    cells[i].y = ((i * cellSize) / width) * cellSize;
  }
}

void draw(){
  for(Cell c : cells){
    fill(255);
    rect(c.x, c.y, cellSize, cellSize);
  }
  
  int c = 0;
  for(int i = 0; i < balls.length; i++){
    Ball b = balls[i];
    float nx = b.x + b.vx;
    float ny = b.y + b.vy;
    
    b.x = nx;
    b.y = ny;
    fill(colors[i]);
    c += 511;
    ellipse(b.x, b.y, ballSize, ballSize); 
  }
}
