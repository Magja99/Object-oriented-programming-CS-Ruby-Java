#include <stdio.h>
#include <math.h>

typedef struct fig
{
        double x_1, y_1, x_2, y_2, x_3, y_3;
        int typfig;
        void(*przes)(const struct fig*, const float, const float);
        float(*pol)(const struct fig*);
        float(*sum)(const struct fig*, const int);

} Figura;

Figura t[1000000];
float a, b, c, d, e, f;
int n;

float pole(Figura *f)
{
        float ans = 0;
        if(f->typfig == 0) // trójkąt
        {
                float p = (f->x_2 - f->x_1)*(f->y_3 - f->y_1) - (f->x_3 - f->x_1)*(f->y_2 - f->y_1);
                if(p < 0.0) p *= -1;
                ans = 1.0/2.0 * p;
        }
        else // kwadrat
        {
                float d = sqrt(pow(f->x_1 - f->x_2, 2) + pow((f->y_1 - f->y_2), 2));
                d /= sqrt(2);
                ans = d * d;
        }
        return ans;
}

void przesun(Figura *f, float x, float y)
{
        f->x_1 += x, f->x_2 += x;
        f->y_1 += y, f->y_2 += y;
        if(f->typfig == 0) // trójkąt
        {
                f->x_3 += x;
                f->y_3 += y;
        }
}

float sumapol(Figura *f, int size)
{
        if(size == n) return 0;
        return f->pol(f) + sumapol(&t[size + 1], size + 1);
}

int main()
{
        scanf("%d", &n);
        for(int i = 0; i < n; i++)
        {
                scanf("%f", &a);
                if(a == 0) // trójkat
                {
                        scanf("%f%f%f%f%f%f", &a, &b, &c, &d, &e, &f);
                        Figura tr = {a, b, c, d, e, f, 0, przesun, pole, sumapol};
                        t[i] = tr;
                }
                if(a == 1)
                {
                        scanf("%f%f%f%f", &a, &b, &c, &d);
                        Figura tr = {a, b, c, d, 1, 1, 1, przesun, pole, sumapol};
                        t[i] = tr;
                }
        }
        printf("%f\n", t[0].sum(&t[0], 0));
        printf("%f\n", t[0].przes(&t[0], 2, 2));
        printf("%f\n", );

}
