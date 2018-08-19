package com.example.AMImaps;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO-WIN on 18/01/2016.
 */
public class Rutas {
    public List<Linea> lineas = new ArrayList();
    public List<LatLng> ruta;

    public void init(){
        /* Terminal */
        ruta = new ArrayList<LatLng>();
        ruta.add(new LatLng	(-2.141724 , -79.878808)	);
        ruta.add(new LatLng	(-2.141017 , -79.880492)	);
        ruta.add(new LatLng	(-2.139537 , -79.882917)	);
        ruta.add(new LatLng	(-2.138679 , -79.88296)	);
        ruta.add(new LatLng	(-2.138679 , -79.882445)	);
        ruta.add(new LatLng	(-2.139087 , -79.882241)	);
        ruta.add(new LatLng	(-2.139859 , -79.88237)	);
        ruta.add(new LatLng	(-2.141617 , -79.883228)	);
        ruta.add(new LatLng	(-2.145037 , -79.885084)	);
        ruta.add(new LatLng	(-2.144726 , -79.886436)	);
        ruta.add(new LatLng	(-2.142057 , -79.888549)	);
        ruta.add(new LatLng	(-2.142357 , -79.890609)	);
        ruta.add(new LatLng	(-2.144437 , -79.895073)	);
        ruta.add(new LatLng	(-2.146881 , -79.899815)	);
        ruta.add(new LatLng	(-2.149004 , -79.898356)	);
        ruta.add(new LatLng	(-2.151695 , -79.896778)	);
        ruta.add(new LatLng	(-2.154097 , -79.895223)	);
        ruta.add(new LatLng	(-2.155598 , -79.895824)	);
        ruta.add(new LatLng	(-2.157785 , -79.898205)	);
        ruta.add(new LatLng	(-2.159950 , -79.898978)	);
        ruta.add(new LatLng	(-2.162030 , -79.898506)	);

        lineas.add(new Linea(5,new LatLng(-2.142500, -79.879006),ruta));


        /* Malecón */
        ruta = new ArrayList<LatLng>();
        ruta.add(new LatLng	(-2.185790 , -79.895724)	);
        ruta.add(new LatLng	(-2.188127 , -79.896454)	);
        ruta.add(new LatLng	(-2.187934 , -79.897141)	);
        ruta.add(new LatLng	(-2.189097 , -79.897484)	);
        ruta.add(new LatLng	(-2.191092 , -79.898106)	);
        ruta.add(new LatLng	(-2.191579 , -79.895842)	);
        ruta.add(new LatLng	(-2.192062 , -79.893723)	);
        ruta.add(new LatLng	(-2.192528 , -79.891503)	);
        ruta.add(new LatLng	(-2.192625 , -79.890955)	);
        ruta.add(new LatLng	(-2.194131 , -79.891497)	);
        ruta.add(new LatLng	(-2.194849 , -79.891739)	);
        ruta.add(new LatLng	(-2.195691 , -79.891991)	);
        ruta.add(new LatLng	(-2.195857 , -79.891154)	);
        ruta.add(new LatLng	(-2.196007 , -79.890408)	);
        ruta.add(new LatLng	(-2.196195 , -79.889791)	);
        ruta.add(new LatLng	(-2.196843 , -79.886347)	);
        ruta.add(new LatLng	(-2.198474 , -79.886633)	);
        ruta.add(new LatLng	(-2.199399 , -79.886802)	);
        ruta.add(new LatLng	(-2.199937 , -79.886915)	);
        ruta.add(new LatLng	(-2.200586 , -79.885013)	);
        ruta.add(new LatLng	(-2.199498 , -79.884734)	);
        ruta.add(new LatLng	(-2.198337 , -79.884404)	);
        ruta.add(new LatLng	(-2.195812 , -79.883841)	);
        ruta.add(new LatLng	(-2.196134 , -79.882197)	);
        ruta.add(new LatLng	(-2.196442 , -79.880813)	);
        ruta.add(new LatLng	(-2.194191 , -79.88026)	);
        ruta.add(new LatLng	(-2.193668 , -79.882521)	);

        lineas.add(new Linea(56,new LatLng(-2.194191 , -79.88026),ruta));


        /* Barrio El Astillero */
        ruta = new ArrayList<LatLng>();
        ruta.add(new LatLng	(-2.207770, -79.886259)	);
        ruta.add(new LatLng	(-2.209235 , -79.88665)	);
        ruta.add(new LatLng	(-2.209985 , -79.886801)	);
        ruta.add(new LatLng	(-2.208999 , -79.890073)	);
        ruta.add(new LatLng	(-2.208045 , -79.893528)	);
        ruta.add(new LatLng	(-2.207634 , -79.894914)	);
        ruta.add(new LatLng	(-2.205549 , -79.894228)	);
        ruta.add(new LatLng	(-2.204434 , -79.893906)	);
        ruta.add(new LatLng	(-2.204037 , -79.895408)	);
        ruta.add(new LatLng	(-2.203512 , -79.897334)	);
        ruta.add(new LatLng	(-2.202552 , -79.901035)	);
        ruta.add(new LatLng	(-2.203860 , -79.901475)	);
        ruta.add(new LatLng	(-2.205259 , -79.901867)	);
        ruta.add(new LatLng	(-2.206374 , -79.902253)	);
        ruta.add(new LatLng	(-2.208958 , -79.903036)	);

        lineas.add(new Linea(98,new LatLng(-2.207770, -79.886259),ruta));


        /* Alborada (Mc Donalds) */
        ruta = new ArrayList<LatLng>();
        ruta.add(new LatLng	(-2.131401 , -79.8989)	);
        ruta.add(new LatLng	(-2.131932 , -79.899522)	);
        ruta.add(new LatLng	(-2.133052 , -79.89882)	);
        ruta.add(new LatLng	(-2.134259 , -79.900429)	);
        ruta.add(new LatLng	(-2.135111 , -79.90155)	);
        ruta.add(new LatLng	(-2.137357 , -79.904543)	);
        ruta.add(new LatLng	(-2.138343 , -79.90597)	);
        ruta.add(new LatLng	(-2.139994 , -79.908089)	);
        ruta.add(new LatLng	(-2.140107 , -79.908722)	);
        ruta.add(new LatLng	(-2.140804 , -79.908722)	);
        ruta.add(new LatLng	(-2.146170 , -79.911002)	);
        ruta.add(new LatLng	(-2.146695 , -79.911979)	);
        ruta.add(new LatLng	(-2.144170 , -79.917536)	);
        ruta.add(new LatLng	(-2.143522 , -79.919221)	);
        ruta.add(new LatLng	(-2.140729 , -79.925379)	);
        ruta.add(new LatLng	(-2.140257 , -79.926575)	);
        ruta.add(new LatLng	(-2.140070 , -79.928372)	);
        ruta.add(new LatLng	(-2.136419 , -79.928083)	);

        lineas.add(new Linea(123,new LatLng(-2.135797, -79.901494),ruta));


        /* Martha Roldós */
//        ruta = new ArrayList<LatLng>();
//        lineas.add(new Linea(45,new LatLng(-2.141042, -79.923633),ruta));
//        lineas.add(new Linea(197,new LatLng(-2.203119, -79.91099),ruta));

        /* Línea 92 */
        ruta = new ArrayList<LatLng>();
        ruta.add(new LatLng(	-2.141894,-79.879156	));
        ruta.add(new LatLng(	-2.139021,-79.883577	));
        ruta.add(new LatLng(	-2.141444,-79.888619	));
        ruta.add(new LatLng(	-2.141401,-79.889327	));
        ruta.add(new LatLng(	-2.141755,-79.889392	));
        ruta.add(new LatLng(	-2.14451,-79.895078	));
        ruta.add(new LatLng(	-2.149022,-79.892331	));
        ruta.add(new LatLng(	-2.149726,-79.892299	));
        ruta.add(new LatLng(	-2.153109,-79.89452	));
        ruta.add(new LatLng(	-2.153345,-79.895464	));
        ruta.add(new LatLng(	-2.153173,-79.896559	));
        ruta.add(new LatLng(	-2.152219,-79.897417	));
        ruta.add(new LatLng(	-2.151803,-79.897315	));
        ruta.add(new LatLng(	-2.151878,-79.896768	));
        ruta.add(new LatLng(	-2.152618,-79.896371	));
        ruta.add(new LatLng(	-2.153915,-79.895309	));
        ruta.add(new LatLng(	-2.154559,-79.895255	));
        ruta.add(new LatLng(	-2.155438,-79.895727	));
        ruta.add(new LatLng(	-2.157368,-79.897776	));
        ruta.add(new LatLng(	-2.15874,-79.898753	));
        ruta.add(new LatLng(	-2.159651,-79.898989	));
        ruta.add(new LatLng(	-2.16038,-79.898989	));
        ruta.add(new LatLng(	-2.161828,-79.898602	));
        ruta.add(new LatLng(	-2.164261,-79.896864	));
        ruta.add(new LatLng(	-2.165366,-79.896038	));
        ruta.add(new LatLng(	-2.166288,-79.895867	));
        ruta.add(new LatLng(	-2.167092,-79.89607	));
        ruta.add(new LatLng(	-2.17033,-79.898334	));
        ruta.add(new LatLng(	-2.171155,-79.898935	));
        ruta.add(new LatLng(	-2.173213,-79.898624	));
        ruta.add(new LatLng(	-2.176366,-79.897969	));
        ruta.add(new LatLng(	-2.178574,-79.897529	));
        ruta.add(new LatLng(	-2.179475,-79.897068	));
        ruta.add(new LatLng(	-2.180182,-79.897025	));
        ruta.add(new LatLng(	-2.181415,-79.896446	));
        ruta.add(new LatLng(	-2.184128,-79.895319	));
        ruta.add(new LatLng(	-2.187076,-79.896178	));
        ruta.add(new LatLng(	-2.190378,-79.897218	));
        ruta.add(new LatLng(	-2.191203,-79.897487	));
        ruta.add(new LatLng(	-2.194248,-79.898431	));
        ruta.add(new LatLng(	-2.199266,-79.899997	));
        ruta.add(new LatLng(	-2.203286,-79.901306	));
        ruta.add(new LatLng(	-2.206384,-79.902272	));
        ruta.add(new LatLng(	-2.211198,-79.903774	));
        ruta.add(new LatLng(	-2.21599,-79.905265	));
        ruta.add(new LatLng(	-2.217352,-79.905662	));
        ruta.add(new LatLng(	-2.219356,-79.906166	));
        ruta.add(new LatLng(	-2.219,-79.908854	));
        ruta.add(new LatLng(	-2.21566,-79.908455	));
        ruta.add(new LatLng(	-2.21473,-79.908308	));
        ruta.add(new LatLng(	-2.213781,-79.908246	));
        ruta.add(new LatLng(	-2.211765,-79.90797	));
        ruta.add(new LatLng(	-2.207671,-79.907507	));
        ruta.add(new LatLng(	-2.204379,-79.906467	));
        ruta.add(new LatLng(	-2.202053,-79.905769	));
        ruta.add(new LatLng(	-2.201345,-79.905458	));
        ruta.add(new LatLng(	-2.199426,-79.904868	));
        ruta.add(new LatLng(	-2.200198,-79.901821	));
        ruta.add(new LatLng(	-2.199008,-79.901413	));
        ruta.add(new LatLng(	-2.197732,-79.900877	));
        ruta.add(new LatLng(	-2.19636,-79.900448	));
        ruta.add(new LatLng(	-2.19547,-79.900169	));
        ruta.add(new LatLng(	-2.194002,-79.899729	));
        ruta.add(new LatLng(	-2.192008,-79.899053	));
        ruta.add(new LatLng(	-2.190989,-79.898785	));
        ruta.add(new LatLng(	-2.191225,-79.897444	));
        ruta.add(new LatLng(	-2.191396,-79.8968	));
        ruta.add(new LatLng(	-2.187269,-79.89547	));
        ruta.add(new LatLng(	-2.185296,-79.894815	));
        ruta.add(new LatLng(	-2.184374,-79.894622	));
        ruta.add(new LatLng(	-2.184149,-79.895212	));
        ruta.add(new LatLng(	-2.180461,-79.896714	));
        ruta.add(new LatLng(	-2.179614,-79.896907	));
        ruta.add(new LatLng(	-2.178595,-79.89739	));
        ruta.add(new LatLng(	-2.175122,-79.898109	));
        ruta.add(new LatLng(	-2.171445,-79.89872	));
        ruta.add(new LatLng(	-2.17048,-79.898248	));
        ruta.add(new LatLng(	-2.168078,-79.8965	));
        ruta.add(new LatLng(	-2.166974,-79.895759	));
        ruta.add(new LatLng(	-2.165719,-79.895727	));
        ruta.add(new LatLng(	-2.164508,-79.896371	));
        ruta.add(new LatLng(	-2.161922,-79.898297	));
        ruta.add(new LatLng(	-2.16051,-79.898779	));
        ruta.add(new LatLng(	-2.159132,-79.898677	));
        ruta.add(new LatLng(	-2.157921,-79.898093	));
        ruta.add(new LatLng(	-2.156768,-79.897009	));
        ruta.add(new LatLng(	-2.15545,-79.895604	));
        ruta.add(new LatLng(	-2.154158,-79.894922	));
        ruta.add(new LatLng(	-2.152335,-79.893844	));
        ruta.add(new LatLng(	-2.149938,-79.892256	));
        ruta.add(new LatLng(	-2.148756,-79.89231	));
        ruta.add(new LatLng(	-2.146149,-79.894032	));
        ruta.add(new LatLng(	-2.144589,-79.894944	));
        ruta.add(new LatLng(	-2.141973,-79.889461	));
        ruta.add(new LatLng(	-2.142037,-79.888802	));
        ruta.add(new LatLng(	-2.14155,-79.888517	));
        ruta.add(new LatLng(	-2.139169,-79.883695	));
        ruta.add(new LatLng(	-2.140172,-79.882852	));
        ruta.add(new LatLng(	-2.140745,-79.88186	));
        ruta.add(new LatLng(	-2.141223,-79.880594	));
        ruta.add(new LatLng(	-2.141978,-79.879655	));
        ruta.add(new LatLng(	-2.141894,-79.879156	));
        lineas.add(new Linea(92,new LatLng(-2.141894,-79.879156),ruta));




        /* mi ruta */
        ruta = new ArrayList<LatLng>();
        ruta.add(new LatLng(-2.120568, -79.594029));
        ruta.add(new LatLng(-2.120547, -79.593053));
        ruta.add(new LatLng(-2.12111, -79.593089));
        ruta.add(new LatLng(-2.121727, -79.593221));
        ruta.add(new LatLng(-2.122255, -79.593274));
        ruta.add(new LatLng(-2.122579, -79.593339));
        ruta.add(new LatLng(-2.122941, -79.593384));
        ruta.add(new LatLng(-2.123375, -79.593435));
        ruta.add(new LatLng(-2.124083, -79.593519));
        ruta.add(new LatLng(-2.124364, -79.593454));
        ruta.add(new LatLng(-2.124967, -79.593505));
        ruta.add(new LatLng(-2.125651, -79.593591));
        ruta.add(new LatLng(-2.126423, -79.593685));
        ruta.add(new LatLng(-2.127042, -79.593749));
        ruta.add(new LatLng(-2.127444, -79.5938));
        lineas.add(new Linea(1,new LatLng(-2.1233750608046977, -79.59342498332262),ruta));

    }

    public class Linea {
        private int numero;
        private LatLng inicio;
        private List<LatLng> recorrido;

        public Linea(int numero, LatLng inicio, List<LatLng> recorrido){
            this.inicio = inicio;
            this.numero = numero;
            this.recorrido = recorrido;
        }

        public List<LatLng> getRecorrido() {
            return recorrido;
        }

        public void setRecorrido(List<LatLng> recorrido) {
            this.recorrido = recorrido;
        }

        public LatLng getInicio() {
            return inicio;
        }

        public void setInicio(LatLng inicio) {
            this.inicio = inicio;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }
    }
}
