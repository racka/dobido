package hu.nooon.dobido.client;

import com.google.gwt.resources.client.ImageResource;
import hu.nooon.dobido.client.resource.SiteClientBundle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.base.Attrs;

public class ImageRepository {

    private SiteClientBundle clientBundle = SiteClientBundle.INSTANCE;

    private Set homeBand;
    private Set homeGallery, homeMusic, homeTour, homeNews;
    private Set bandBezs, bandBezsAlt, bandErvin, bandErvinAlt, bandRacka, bandRackaAlt, bandZadi, bandZadiAlt;
    private Set music, partners, tour, news;


    private Paper paper;

    public ImageRepository(Paper paper) {
        this.paper = paper;
    }

    private Set addToRepository(Paper paper, ImageResource... resources) {
        Set container = paper.set();
        for (ImageResource resource : resources) {
            container.push(paper.image(resource, 0, 0, resource.getWidth(), resource.getHeight()).hide());
        }
        container.attr(Attrs.create().opacity(0));
        return container;
    }


    public Set getHomeBand() {
        if (homeBand == null) {
            homeBand = addToRepository(paper, 
                    clientBundle.home_band_bezs(), clientBundle.home_band_ervin(), clientBundle.home_band_racka(), clientBundle.home_band_zadi());
        }
        return homeBand;
    }

    public Set getHomeGallery() {
        if (homeGallery == null) {
            homeGallery = addToRepository(paper, clientBundle.home_gallery1(), clientBundle.home_gallery2());
        }
        return homeGallery;
    }

    public Set getHomeMusic() {
        if (homeMusic == null) {
            homeMusic = addToRepository(paper,clientBundle.home_music1(), clientBundle.home_music2());
        }
        return homeMusic;
    }

    public Set getHomeTour() {
        if (homeTour == null) {
            homeTour = addToRepository(paper,clientBundle.home_tour1(), clientBundle.home_tour2(),
                    clientBundle.home_tour3(), clientBundle.home_tour4());
        }
        return homeTour;
    }

    public Set getHomeNews() {
        if (homeNews == null) {
            homeNews = addToRepository(paper,clientBundle.home_news1(), clientBundle.home_news2(),
                    clientBundle.home_news3(), clientBundle.home_news4());
        }
        return homeNews;
    }


    public Set getBandBezs() {
        if (bandBezs == null) {
            bandBezs = addToRepository(paper,clientBundle.band_bezs());
        }
        return bandBezs;
    }

    public Set getBandBezsAlt() {
        if (bandBezsAlt == null) {
            bandBezsAlt = addToRepository(paper,clientBundle.band_bezs_alt());
        }
        return bandBezsAlt;
    }

    public Set getBandErvin() {
        if (bandErvin == null) {
            bandErvin = addToRepository(paper,clientBundle.band_ervin());
        }
        return bandErvin;
    }

    public Set getBandErvinAlt() {
        if (bandErvinAlt == null) {
            bandErvinAlt = addToRepository(paper,clientBundle.band_ervin_alt());
        }
        return bandErvinAlt;
    }

    public Set getBandRacka() {
        if (bandRacka == null) {
            bandRacka = addToRepository(paper,clientBundle.band_racka());
        }
        return bandRacka;
    }

    public Set getBandRackaAlt() {
        if (bandRackaAlt == null) {
            bandRackaAlt = addToRepository(paper,clientBundle.band_racka_alt());
        }
        return bandRackaAlt;
    }

    public Set getBandZadi() {
        if (bandZadi == null) {
            bandZadi = addToRepository(paper,clientBundle.band_zadi());
        }
        return bandZadi;
    }

    public Set getBandZadiAlt() {
        if (bandZadiAlt == null) {
            bandZadiAlt = addToRepository(paper,clientBundle.band_zadi_alt());
        }
        return bandZadiAlt;
    }

    public Set getMusic() {
        if (music == null) {
            music = addToRepository(paper,
                    clientBundle.music1(), clientBundle.music2(), clientBundle.music3(), clientBundle.music4(), clientBundle.music5(),
                    clientBundle.music6(), clientBundle.music7(), clientBundle.music8(), clientBundle.music9(), clientBundle.music10(),
                    clientBundle.music11(), clientBundle.music12(), clientBundle.music13(), clientBundle.music14(), clientBundle.music15(),
                    clientBundle.music16());
        }
        return music;
    }

    public Set getPartners() {
        if (partners == null) {
            partners = addToRepository(paper,
                    clientBundle.partners1(), clientBundle.partners2(), clientBundle.partners3(), clientBundle.partners4(), clientBundle.partners5(),
                    clientBundle.partners6(), clientBundle.partners7(), clientBundle.partners8(), clientBundle.partners9(), clientBundle.partners10(),
                    clientBundle.partners11(), clientBundle.partners12(), clientBundle.partners13(), clientBundle.partners14(), clientBundle.partners15(),
                    clientBundle.partners16());
        }
        return partners;
    }

    public Set getTour() {
        if (tour == null) {
            tour = addToRepository(paper,
                    clientBundle.tour1(), clientBundle.tour2(), clientBundle.tour3(), clientBundle.tour4(), clientBundle.tour5(),
                    clientBundle.tour6(), clientBundle.tour7(), clientBundle.tour8(), clientBundle.tour9(), clientBundle.tour10(),
                    clientBundle.tour11(), clientBundle.tour12(), clientBundle.tour13(), clientBundle.tour14(), clientBundle.tour15(),
                    clientBundle.tour16());
        }
        return tour;
    }

    public Set getNews() {
        if (news == null) {
            news = addToRepository(paper,
                    clientBundle.news1(), clientBundle.news2(), clientBundle.news3(), clientBundle.news4(), clientBundle.news5(),
                    clientBundle.news6(), clientBundle.news7(), clientBundle.news8(), clientBundle.news9(), clientBundle.news10(),
                    clientBundle.news11(), clientBundle.news12(), clientBundle.news13(), clientBundle.news14(), clientBundle.news15(),
                    clientBundle.news16()
            );
        }
        return news;
    }
}
